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

import javax.xml.stream.XMLStreamReader;

import org.flowable.crystalball.model.BaseElement;
import org.flowable.crystalball.model.ScenarioParameters;
import org.flowable.crystalball.model.TimeUnit;

/**
 * @author martin.grofcik
 */
public class ScenarioParametersXmlConverter extends BaseBpSimXmlConverter {

    @Override
    public String getXMLElementName() {
        return BpSimXmlConstants.ELEMENT_SCENARIO_PARAMETERS;
    }
    
    @Override
    public boolean hasChildElements() {
        return true;
    }

    @Override
    protected BaseElement convert(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        ScenarioParameters scenarioParameters = new ScenarioParameters();
        scenarioParameters.setBaseTimeUnit(TimeUnit.fromValue(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_BASE_TIME_UNIT)));
        scenarioParameters.setBaseCurrencyUnit(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_BASE_CURRENCY_UNIT));
        String replication = xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_REPLICATION);
        scenarioParameters.setReplication(replication != null ? Integer.parseInt(replication) : null);

        String seed = xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_SEED);
        scenarioParameters.setSeed(seed != null ? Long.parseLong(seed) : null);
        conversionHelper.getCurrentScenario().setScenarioParameters(scenarioParameters);
        conversionHelper.addElement(scenarioParameters);
        return scenarioParameters;
    }
    
}