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
package org.flowable.crystalball.converter.export;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.StringUtils;
import org.flowable.crystalball.converter.BpSimXmlConstants;
import org.flowable.crystalball.model.ElementParameters;
import org.flowable.crystalball.model.Parameter;
import org.flowable.crystalball.model.ParameterValue;
import org.flowable.crystalball.model.Scenario;
import org.flowable.crystalball.model.ScenarioParameters;
import org.flowable.crystalball.model.TimeParameters;
import org.flowable.crystalball.model.UniformDistribution;

/**
 * @author martin.grofcik
 */
public class ScenarioExport implements BpSimXmlConstants {

    private static final SimpleDateFormat XSD_DATETIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH':'mm':'ss");

    static Map<Class, XmlExporter> exporters = new HashMap<>();

    static {
        exporters.put(UniformDistribution.class, new UniformDistributionExporter());
    }

    public static void writeScenario(Scenario scenario, XMLStreamWriter xtw) throws Exception {
        xtw.writeStartElement(ELEMENT_SCENARIO);
        xtw.writeAttribute(ATTRIBUTE_ID, scenario.getId());

        putIfNotEmpty(xtw, scenario.getName(), ATTRIBUTE_NAME);
        putIfNotEmpty(xtw, scenario.getDescription(), ATTRIBUTE_DESCRIPTION);
        putIfNotEmpty(xtw, scenario.getAuthor(), ATTRIBUTE_AUTHOR);
        putIfNotEmpty(xtw, scenario.getVendor(), ATTRIBUTE_VENDOR);
        putIfNotEmpty(xtw, scenario.getVersion(), ATTRIBUTE_VERSION);
        if (scenario.getCreated() != null) {
            putIfNotEmpty(xtw, XSD_DATETIME_FORMATTER.format(scenario.getCreated()), ATTRIBUTE_CREATED);
        }
        if (scenario.getModified() != null) {
            putIfNotEmpty(xtw, XSD_DATETIME_FORMATTER.format(scenario.getModified()), ATTRIBUTE_MODIFIED);
        }

        if (scenario.getScenarioParameters() != null) {
            writeScenarioParameters(scenario.getScenarioParameters(), xtw);
        }

        if (scenario.getElementParameters() != null) {
            for (ElementParameters elementParameter : scenario.getElementParameters()) {
                writeElementParameters(elementParameter, xtw);
            }
        }
    }

    public static void writeScenarioParameters(ScenarioParameters scenarioParameters, XMLStreamWriter xtw) throws Exception {
        xtw.writeStartElement(ELEMENT_SCENARIO_PARAMETERS);

        putIfNotNull(xtw, scenarioParameters.getSeed(), ATTRIBUTE_SEED);
        putIfNotNull(xtw, scenarioParameters.getReplication(), ATTRIBUTE_REPLICATION);
        if( scenarioParameters.getBaseTimeUnit() != null) {
            putIfNotNull(xtw, scenarioParameters.getBaseTimeUnit().value(), ATTRIBUTE_BASE_TIME_UNIT);
        }
        if( scenarioParameters.getBaseCurrencyUnit() != null) {
            putIfNotNull(xtw, scenarioParameters.getBaseCurrencyUnit(), ATTRIBUTE_BASE_CURRENCY_UNIT);
        }

    }

    public static void writeElementParameters(ElementParameters elementParameters, XMLStreamWriter xtw) throws Exception {
        xtw.writeStartElement(ELEMENT_ELEMENT_PARAMETERS);

        putIfNotNull(xtw, elementParameters.getId(), ATTRIBUTE_ID);
        putIfNotNull(xtw, elementParameters.getElementRef(), ATTRIBUTE_ELEMENT_REF);

        if (elementParameters.getTimeParameters() != null) {
            writeTimeParameters(elementParameters.getTimeParameters(), xtw);
        }
    }

    protected static void writeTimeParameters(TimeParameters timeParameters, XMLStreamWriter xtw) throws Exception {
        xtw.writeStartElement(ELEMENT_TIME_PARAMETERS);
        if (timeParameters.getProcessingTime() != null) {
            writeProcessingTime(timeParameters.getProcessingTime(), xtw);
        }
    }

    protected static void writeProcessingTime(Parameter parameter, XMLStreamWriter xtw) throws Exception {
        xtw.writeStartElement(ELEMENT_PROCESSING_TIME);
        for (ParameterValue parameterValue : parameter.getParameterValue()) {
            exporters.get(parameterValue.getClass()).export(parameterValue, xtw);
        }
    }

    protected static void putIfNotNull(XMLStreamWriter xtw, Object value, String attributeName) throws XMLStreamException {
        if (value!= null) {
            xtw.writeAttribute(attributeName, value.toString());
        }
    }

    protected static void putIfNotEmpty(XMLStreamWriter xtw, String value, String attributeName) throws XMLStreamException {
        if (StringUtils.isNotEmpty(value)) {
            xtw.writeAttribute(attributeName, value);
        }
    }
}
