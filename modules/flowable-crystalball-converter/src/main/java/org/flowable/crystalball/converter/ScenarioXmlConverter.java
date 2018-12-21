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

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.flowable.crystalball.model.BpSimElement;
import org.flowable.crystalball.model.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author martin.grofcik
 */
public class ScenarioXmlConverter extends BaseBpSimXmlConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScenarioXmlConverter.class);

    private static final SimpleDateFormat XSD_DATETIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH':'mm':'ss");

    @Override
    public String getXMLElementName() {
        return BpSimXmlConstants.ELEMENT_SCENARIO;
    }
    
    @Override
    public boolean hasChildElements() {
        return true;
    }

    @Override
    protected BpSimElement convert(XMLStreamReader xtr, ConversionHelper conversionHelper) {
        Scenario scenario = new Scenario();
        scenario.setId(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_ID));
        scenario.setName(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_NAME));
        scenario.setDescription(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_DESCRIPTION));
        scenario.setAuthor(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_AUTHOR));
        scenario.setVendor(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_VENDOR));
        scenario.setVersion(xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_VERSION));
        String created = xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_CREATED);
        if (StringUtils.isNotEmpty(created)) {
            try {
                scenario.setCreated(XSD_DATETIME_FORMATTER.parse(created));
            } catch (ParseException e) {
                LOGGER.warn("Ignoring created attribute: invalid date format", e);
            }
        }
        String modified = xtr.getAttributeValue(null, BpSimXmlConstants.ATTRIBUTE_MODIFIED);
        if (StringUtils.isNotEmpty(modified)) {
            try {
                scenario.setModified(XSD_DATETIME_FORMATTER.parse(modified));
            } catch (ParseException e) {
                LOGGER.warn("Ignoring modified attribute: invalid date format", e);
            }
        }
        conversionHelper.setCurrentScenario(scenario);
        conversionHelper.addElement(scenario);

        return scenario;
    }
    
}