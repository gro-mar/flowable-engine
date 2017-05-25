package org.flowable.rest.service.api.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.engine.ManagementService;
import org.flowable.engine.impl.event.logger.handler.AbstractDatabaseEventLoggerEventHandler;
import org.flowable.engine.impl.interceptor.Command;
import org.flowable.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.persistence.entity.EventLogEntryEntity;
import org.flowable.rest.service.api.RestResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Manages EventLog entries
 *
 * @author martin.grofcik
 */
public class EventLogBaseResource {

    @Autowired
    protected ManagementService managementService;

    @Autowired
    protected RestResponseFactory restResponseFactory;

    @Autowired
    protected ObjectMapper objectMapper;

    protected List<EventLogEntryResponse> getQueryResponse(String processInstanceId) {
        assert processInstanceId != null;

        return this.restResponseFactory.createEventLogResponseList(
                this.managementService.getEventLogEntriesByProcessInstanceId(processInstanceId)
        );
    }

    protected void inserEventLogEntry(final EventLogInsertRequest eventLogInsertRequest) {
        this.managementService.executeCommand(new Command<Void>() {
            @Override
            public Void execute(CommandContext commandContext) {
                ExternalEventHandler externalEventHandler = new ExternalEventHandler(
                        eventLogInsertRequest.getType(),
                        eventLogInsertRequest.getProcessDefinitionId(),
                        eventLogInsertRequest.getProcessInstanceId(),
                        eventLogInsertRequest.getExecutionId(),
                        eventLogInsertRequest.getTaskId(),
                        eventLogInsertRequest.getData()
                );
                externalEventHandler.setTimeStamp(commandContext.getProcessEngineConfiguration().getClock().getCurrentTime());
                externalEventHandler.setObjectMapper(objectMapper);
                EventLogEntryEntity eventLogEntryEntity = externalEventHandler.generateEventLogEntry(commandContext);
                commandContext.getEventLogEntryEntityManager().insert(eventLogEntryEntity);
                return null;
            }
        });
    }

    private class ExternalEventHandler extends AbstractDatabaseEventLoggerEventHandler {
        private Map<String, Object> data;
        private String type;
        private String processDefinitionId;
        private String processInstanceId;
        private String executionId;

        public ExternalEventHandler(String type, String processDefinitionId, String processInstanceId, String executionId, String taskId, Map<String, Object> data) {
            this.data = data;
            this.type = type;
            this.processDefinitionId = processDefinitionId;
            this.processInstanceId = processInstanceId;
            this.executionId = executionId;
            this.taskId = taskId;
        }

        private String taskId;

        @Override
        public EventLogEntryEntity generateEventLogEntry(CommandContext commandContext) {
            return createEventLogEntry(this.type, this.processDefinitionId, this.processInstanceId, this.executionId,
                    this.taskId, this.data);
        }
    }
}
