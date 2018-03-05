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
package org.flowable.engine.test.api.event;

import org.flowable.engine.common.api.delegate.event.FlowableEvent;
import org.flowable.engine.delegate.event.AbstractFlowableEngineEventListener;

public class TestExceptionFlowableEventListener extends AbstractFlowableEngineEventListener {

    private boolean failOnException;

    public TestExceptionFlowableEventListener(boolean failOnException) {
        this.failOnException = failOnException;
    }

    @Override
    public void onEvent(FlowableEvent event) {
        throw new RuntimeException("Test exception");
    }

    @Override
    public boolean isFailOnException() {
        return failOnException;
    }

}
