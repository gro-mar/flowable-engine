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
package org.flowable.editor.language.json.converter;

import java.util.Map;

public class StandaloneBpmnConverterContext implements BpmnJsonConverterContext {

    @Override
    public String getFormModelKeyForFormModelId(String formModelId) {
        return null;
    }
    @Override
    public Map<String, String> getFormModelInfoForFormModelKey(String formModelKey) {
        return null;
    }
    @Override
    public String getProcessModelKeyForProcessModelId(String processModelId) {
        return null;
    }
    @Override
    public Map<String, String> getProcessModelInfoForProcessModelKey(String processModelKey) {
        return null;
    }
    @Override
    public String getDecisionModelKeyForDecisionModelId(String decisionModelId) {
        return null;
    }
    @Override
    public Map<String, String> getDecisionModelInfoForDecisionModelKey(String decisionModelKey) {
        return null;
    }
}