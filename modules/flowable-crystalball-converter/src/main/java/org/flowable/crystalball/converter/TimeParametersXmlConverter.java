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
import org.flowable.crystalball.model.TimeParameters;

/**
 * @author martin.grofcik
 */
public class TimeParametersXmlConverter extends BaseBpSimXmlConverter {

    @Override
    public String getXMLElementName() {
        return BpSimXmlConstants.ELEMENT_TIME_PARAMETERS;
    }
    
    @Override
    public boolean hasChildElements() {
        return true;
    }

    @Override
    protected BaseElement convert(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        TimeParameters timeParameters = new TimeParameters();
        BaseElement currentBpSimElement = conversionHelper.getCurrentBpSimElement();
        if (currentBpSimElement instanceof ElementParameters){
            ((ElementParameters) currentBpSimElement).setTimeParameters(timeParameters);
        }
        conversionHelper.addElement(timeParameters);
        return timeParameters;
    }
    
}