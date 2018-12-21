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

import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamReader;

import org.flowable.crystalball.model.BaseElement;
import org.flowable.crystalball.model.BpSimElement;
import org.flowable.crystalball.model.Scenario;

public abstract class BaseBpSimXmlConverter implements BpSimXmlConstants {

    public abstract String getXMLElementName();

    /**
     * @return True of the current {@link org.flowable.crystalball.model.BpSimElement} can have child elements and needs to be pushed
     *         to the stack of elements during parsing. 
     */
    public abstract boolean hasChildElements();

    public BaseElement convertToBpSimModel(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        BaseElement baseElement = convert(xtr, conversionHelper);
        if (baseElement != null) {

            Location location = xtr.getLocation();
            baseElement.setXmlRowNumber(location.getLineNumber());
            baseElement.setXmlRowNumber(location.getColumnNumber());

            if (baseElement instanceof BpSimElement) {
                BpSimElement bpSimElement = (BpSimElement) baseElement;
                conversionHelper.setCurrentBpSimElement(bpSimElement);
            }

            if (baseElement instanceof Scenario) {
                Scenario scenario = (Scenario) baseElement;
                conversionHelper.getBpSimModel().addScenario(scenario.getId(), scenario);
                conversionHelper.setCurrentScenario(scenario);
            }

        }
        return baseElement;
    }

    protected abstract BaseElement convert(XMLStreamReader xtr, ConversionHelper conversionHelper);

    protected void elementEnd(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        if (hasChildElements()) {
            conversionHelper.removeCurrentBpSimElement();
        }
    }

}
