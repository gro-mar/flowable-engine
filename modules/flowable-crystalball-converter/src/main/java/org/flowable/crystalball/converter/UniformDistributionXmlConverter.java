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
import org.flowable.crystalball.model.Parameter;
import org.flowable.crystalball.model.TimeUnit;
import org.flowable.crystalball.model.UniformDistribution;

/**
 * @author martin.grofcik
 */
public class UniformDistributionXmlConverter extends BaseBpSimXmlConverter {

    @Override
    public String getXMLElementName() {
        return BpSimXmlConstants.ELEMENT_UNIFORM_DISTRIBUTION;
    }
    
    @Override
    public boolean hasChildElements() {
        return true;
    }

    @Override
    protected BaseElement convert(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        UniformDistribution uniformDistribution = new UniformDistribution();
        BaseElement currentBpSimElement = conversionHelper.getCurrentBpSimElement();
        String max = xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_MAX);
        if (max != null) {
            uniformDistribution.setMax(Double.parseDouble(max));
        }
        String min = xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_MIN);
        if (min != null) {
            uniformDistribution.setMin(Double.parseDouble(min));
        }
        uniformDistribution.setTimeUnit(TimeUnit.fromValue(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_TIME_UNIT)));
        if (currentBpSimElement instanceof Parameter) {
            ((Parameter) currentBpSimElement).addParameterValue(uniformDistribution);
        }
        conversionHelper.addElement(uniformDistribution);
        return uniformDistribution;
    }
    
}