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
package org.flowable.crystalball.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.flowable.crystalball.model.BaseElement;
import org.flowable.crystalball.model.BpSimElement;
import org.flowable.crystalball.model.BpSimModel;
import org.flowable.crystalball.model.Scenario;

/**
 * @author martin.grofcik
 */
public class ConversionHelper {

    protected BpSimModel bpSimModel;
    protected Scenario currentScenario;
    protected LinkedList<BaseElement> currentBpSimElements = new LinkedList<>();

    protected Map<Scenario, List<BaseElement>> bpSimElements = new HashMap<>();

    public void addElement(BaseElement baseElement) {
        if (!bpSimElements.containsKey(currentScenario)) {
            bpSimElements.put(currentScenario, new ArrayList<>());
        }
        bpSimElements.get(currentScenario).add(baseElement);
    }

    public Map<Scenario, List<BaseElement>> getScenarioElements() {
        return bpSimElements;
    }

    public void setBpSimElements(Map<Scenario, List<BaseElement>> bpSimElements) {
        this.bpSimElements = bpSimElements;
    }

    public BpSimModel getBpSimModel() {
        return bpSimModel;
    }

    public void setBpSimModel(BpSimModel bpSimModel) {
        this.bpSimModel = bpSimModel;
    }

    public Scenario getCurrentScenario() {
        return currentScenario;
    }

    public void setCurrentScenario(Scenario currentScenario) {
        this.currentScenario = currentScenario;
    }

    public BaseElement getCurrentBpSimElement() {
        return currentBpSimElements.peekLast();
    }

    public void setCurrentBpSimElement(BpSimElement currentBpSimElement) {
        currentBpSimElements.add(currentBpSimElement);
    }

    public void removeCurrentBpSimElement() {
        currentBpSimElements.removeLast();
    }

}
