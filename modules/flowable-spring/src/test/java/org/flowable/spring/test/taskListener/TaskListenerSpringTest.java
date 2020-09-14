/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flowable.spring.test.taskListener;

import static org.assertj.core.api.Assertions.assertThat;

import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.SpringFlowableTestCase;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;

/**
 * @author Joram Barrez
 */
@ContextConfiguration("classpath:org/flowable/spring/test/taskListener/TaskListenerDelegateExpressionTest-context.xml")
public class TaskListenerSpringTest extends SpringFlowableTestCase {

    @Test
    @Deployment
    public void testTaskListenerDelegateExpression() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("taskListenerDelegateExpression");

        // Completing first task will set variable on process instance
        Task task = taskService.createTaskQuery().singleResult();
        taskService.complete(task.getId(), Collections.singletonMap("description", "descriptionValue"));
        assertThat(runtimeService.getVariable(processInstance.getId(), "calledInExpression")).isEqualTo("task1-complete");

        // Completing second task will set variable on process instance
        task = taskService.createTaskQuery().singleResult();
        taskService.complete(task.getId());
        assertThat(runtimeService.getVariable(processInstance.getId(), "calledThroughNotify")).isEqualTo("task2-notify");
    }

    @Test
    @Deployment(resources = "org/flowable/spring/test/taskListener/TaskListenerSpringTest.testTaskListenerDelegateExpression.bpmn20.xml")
    public void checkUpdateInMainProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("taskListenerDelegateExpression",
                Collections.singletonMap("descriptions", "initial description value"));

        // Completing first task will set variable on process instance
        Task task = taskService.createTaskQuery().singleResult();
        taskService.complete(task.getId(), Collections.singletonMap("taskDescription", "taskDescriptionValue"));
        assertThat(runtimeService.getVariable(processInstance.getId(), "descriptions"))
                .isEqualTo("initial description value + taskDescriptionValue");

    }

}
