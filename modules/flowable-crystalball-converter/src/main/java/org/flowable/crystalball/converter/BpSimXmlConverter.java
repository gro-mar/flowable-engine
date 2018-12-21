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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.flowable.common.engine.api.io.InputStreamProvider;
import org.flowable.crystalball.converter.exception.XMLException;
import org.flowable.crystalball.converter.export.BpSimDataRootExport;
import org.flowable.crystalball.converter.export.ScenarioExport;
import org.flowable.crystalball.model.BpSimModel;
import org.flowable.crystalball.model.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * @author martin.grofcik
 */
public class BpSimXmlConverter implements BpSimXmlConstants {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BpSimXmlConverter.class);
    protected static final String XSD_LOCATION = "org/flowable/impl/crystalball/parser/BPSIM20.xsd";
    protected static final String DEFAULT_ENCODING = "UTF-8";

    protected static Map<String, BaseBpSimXmlConverter> elementConverters = new HashMap<>();
    protected static Map<String, BaseBpSimXmlConverter> textConverters = new HashMap<>();

    protected ClassLoader classloader;

    static {
        addElementConverter(new BPSimDataXmlConverter());
        addElementConverter(new ScenarioXmlConverter());
        addElementConverter(new ScenarioParametersXmlConverter());
        addElementConverter(new ElementParametersXmlConverter());
        addElementConverter(new TimeParametersXmlConverter());
        addElementConverter(new ProcessingTimeXmlConverter());
        addElementConverter(new UniformDistributionXmlConverter());
    }

    public static void addElementConverter(BaseBpSimXmlConverter converter) {
        elementConverters.put(converter.getXMLElementName(), converter);
    }

    public static void addTextConverter(BaseBpSimXmlConverter converter) {
        textConverters.put(converter.getXMLElementName(), converter);
    }

    public BpSimModel convertToBpSimModel(InputStreamProvider inputStreamProvider) {
        return convertToBpSimModel(inputStreamProvider, true, true);
    }

    public BpSimModel convertToBpSimModel(InputStreamProvider inputStreamProvider, boolean validateSchema, boolean enableSafeBpmnXml) {
        return convertToBpSimModel(inputStreamProvider, validateSchema, enableSafeBpmnXml, DEFAULT_ENCODING);
    }

    public BpSimModel convertToBpSimModel(InputStreamProvider inputStreamProvider, boolean validateSchema, boolean enableSafeBpmnXml, String encoding) {
        XMLInputFactory xif = XMLInputFactory.newInstance();

        if (xif.isPropertySupported(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES)) {
            xif.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        }
        if (xif.isPropertySupported(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES)) {
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        }
        if (xif.isPropertySupported(XMLInputFactory.SUPPORT_DTD)) {
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        }

        if (encoding == null) {
            encoding = DEFAULT_ENCODING;
        }

        if (validateSchema) {
            try (InputStreamReader in = new InputStreamReader(inputStreamProvider.getInputStream(), encoding)) {
                if (!enableSafeBpmnXml) {
                    validateModel(inputStreamProvider);
                } else {
                    validateModel(xif.createXMLStreamReader(in));
                }
            } catch (UnsupportedEncodingException e) {
                throw new BpSimXMLException("The BpSim 2.0 xml is not properly encoded", e);
            } catch (XMLStreamException e) {
                throw new BpSimXMLException("Error while reading the BpSim 2.0 XML", e);
            } catch (Exception e) {
                throw new BpSimXMLException(e.getMessage(), e);
            }
        }
        // The input stream is closed after schema validation
        try (InputStreamReader in = new InputStreamReader(inputStreamProvider.getInputStream(), encoding)) {
            // XML conversion
            return convertToBpSimModel(xif.createXMLStreamReader(in));
        } catch (UnsupportedEncodingException e) {
            throw new BpSimXMLException("The BpSim 2.0 xml is not properly encoded", e);
        } catch (XMLStreamException e) {
            throw new BpSimXMLException("Error while reading the BpSim 2.0 XML", e);
        } catch (IOException e) {
            throw new BpSimXMLException(e.getMessage(), e);
        }
    }

    public BpSimModel convertToBpSimModel(XMLStreamReader xtr) {

        ConversionHelper conversionHelper = new ConversionHelper();
        conversionHelper.setBpSimModel(new BpSimModel());

        try {
            String currentXmlElement = null;
            while (xtr.hasNext()) {
                try {
                    xtr.next();
                } catch (Exception e) {
                    LOGGER.debug("Error reading BpSim XML document", e);
                    throw new BpSimXMLException("Error reading XML", e);
                }

                if (xtr.isStartElement()) {
                    currentXmlElement = xtr.getLocalName();
                    if (elementConverters.containsKey(currentXmlElement)) {
                        elementConverters.get(currentXmlElement).convertToBpSimModel(xtr, conversionHelper);
                    }

                } else if (xtr.isEndElement()) {
                    currentXmlElement = null;
                    if (elementConverters.containsKey(xtr.getLocalName())) {
                        elementConverters.get(xtr.getLocalName()).elementEnd(xtr, conversionHelper);
                    }

                } else if ((xtr.isCharacters() || xtr.getEventType() == XMLStreamReader.CDATA) && currentXmlElement != null) {
                    if (textConverters.containsKey(currentXmlElement)) {
                        textConverters.get(currentXmlElement).convertToBpSimModel(xtr, conversionHelper);
                    }

                }
            }

        } catch (BpSimXMLException e) {
            throw e;

        } catch (Exception e) {
            LOGGER.error("Error processing BpSim XML document", e);
            throw new BpSimXMLException("Error processing BpSim XML document", e);
        }

        // Post process all elements: add instances where a reference is used
        processBpSimElements(conversionHelper);
        return conversionHelper.getBpSimModel();
    }

    public void validateModel(InputStreamProvider inputStreamProvider) throws Exception {
        Schema schema = createSchema();

        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(inputStreamProvider.getInputStream()));
    }

    public void validateModel(XMLStreamReader xmlStreamReader) throws Exception {
        Schema schema = createSchema();

        Validator validator = schema.newValidator();
        validator.validate(new StAXSource(xmlStreamReader));
    }

    protected Schema createSchema() throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        if (classloader != null) {
            schema = factory.newSchema(classloader.getResource(XSD_LOCATION));
        }

        if (schema == null) {
            schema = factory.newSchema(this.getClass().getClassLoader().getResource(XSD_LOCATION));
        }

        if (schema == null) {
            throw new BpSimXMLException("BpSim XSD could not be found");
        }
        return schema;
    }

    public byte[] convertToXML(BpSimModel model) {
        return convertToXML(model, DEFAULT_ENCODING);
    }

    public byte[] convertToXML(BpSimModel model, String encoding) {
        try {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            OutputStreamWriter out = new OutputStreamWriter(outputStream, encoding);

            XMLStreamWriter writer = xof.createXMLStreamWriter(out);
            XMLStreamWriter xtw = new IndentingXMLStreamWriter(writer);

            BpSimDataRootExport.writeRootElement(model, xtw, encoding);

            for (Scenario scenario : model.getScenarios()) {

                ScenarioExport.writeScenario(scenario, xtw);
                // end scenario element
                xtw.writeEndElement();
            }

            // end BPSimData root element
            xtw.writeEndElement();
            xtw.writeEndDocument();

            xtw.flush();

            outputStream.close();

            xtw.close();

            return outputStream.toByteArray();

        } catch (Exception e) {
            LOGGER.error("Error writing BpSim XML", e);
            throw new XMLException("Error writing BpSim XML", e);
        }
    }

    protected void processBpSimElements(ConversionHelper conversionHelper) {
        BpSimModel bpSimModel = conversionHelper.getBpSimModel();
        for (Scenario scenario : bpSimModel.getScenarios()) {
            processScenario(bpSimModel, scenario);
        }
    }

    protected void processScenario(BpSimModel bpSimModel, Scenario scenario) {
    }


    public void setClassloader(ClassLoader classloader) {
        this.classloader = classloader;
    }

    public static Map<String, BaseBpSimXmlConverter> getConvertersToBpSimModelMap() {
        return elementConverters;
    }

    public static void setConvertersToCmmnModelMap(Map<String, BaseBpSimXmlConverter> convertersToBpSimModelMap) {
        BpSimXmlConverter.elementConverters = convertersToBpSimModelMap;
    }

}
