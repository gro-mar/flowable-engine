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
import org.flowable.crystalball.model.ElementParameters;

/**
 * @author martin.grofcik
 */
public class ElementParametersXmlConverter extends BaseBpSimXmlConverter {

    @Override
    public String getXMLElementName() {
        return ELEMENT_ELEMENT_PARAMETERS;
    }
    
    @Override
    public boolean hasChildElements() {
        return true;
    }

    @Override
    protected BaseElement convert(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        ElementParameters elementParameters = new ElementParameters();

        elementParameters.setElementRef(xtr.getAttributeValue(null, ATTRIBUTE_ELEMENT_REF));
        elementParameters.setId(xtr.getAttributeValue(null, ATTRIBUTE_ID));

        conversionHelper.getCurrentScenario().addElementParameters(elementParameters);
        return elementParameters;
    }
    
}