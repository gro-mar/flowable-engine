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

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.StringUtils;
import org.flowable.crystalball.converter.BpSimXmlConstants;
import org.flowable.crystalball.model.TimeUnit;

/**
 * @author martin.grofcik
 */
public abstract class AbstractExporter implements XmlExporter, BpSimXmlConstants {

    protected static void putIfNotNull(XMLStreamWriter xtw, Object value, String attributeName) throws XMLStreamException {
        if (value!= null) {
            xtw.writeAttribute(attributeName, value.toString());
        }
    }

    protected static void putIfNotNull(XMLStreamWriter xtw, TimeUnit timeUnit, String attributeName) throws XMLStreamException {
        if (timeUnit != null) {
            xtw.writeAttribute(attributeName, timeUnit.value());
        }
    }

    protected static void putIfNotEmpty(XMLStreamWriter xtw, String value, String attributeName) throws XMLStreamException {
        if (StringUtils.isNotEmpty(value)) {
            xtw.writeAttribute(attributeName, value);
        }
    }
}
