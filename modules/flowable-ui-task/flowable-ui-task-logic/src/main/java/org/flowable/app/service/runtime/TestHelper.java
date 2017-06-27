package org.flowable.app.service.runtime;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestHelper {

    @Autowired
    protected RuntimeService runtimeService;


    @SuppressWarnings("unused")
    public List<String> getSubProcessInstanceIds(String rootProcessInstanceId) {
        List<Execution> processInstances = runtimeService.createExecutionQuery().rootProcessInstanceId(rootProcessInstanceId).onlyProcessInstanceExecutions().list();

        List<String> processInstanceIds = new ArrayList<>(processInstances.size());
        for (Execution processInstance : processInstances) {
            processInstanceIds.add(processInstance.getId());
        }
        return processInstanceIds;
    }

}
