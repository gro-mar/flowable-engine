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
package org.flowable.test.crystalball.converter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.flowable.common.engine.impl.util.io.InputStreamSource;
import org.flowable.crystalball.converter.BpSimXmlConstants;
import org.flowable.crystalball.converter.BpSimXmlConverter;
import org.flowable.crystalball.model.BpSimModel;

public abstract class AbstractConverterTest implements BpSimXmlConstants {

    protected BpSimModel readXMLFile(String resource) {
        InputStream xmlStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        return new BpSimXmlConverter().convertToBpSimModel(new InputStreamSource(xmlStream), true, false, "UTF-8");
    }

    protected BpSimModel exportAndReadXMLFile(BpSimModel bpSimModel) {
        byte[] xml = new BpSimXmlConverter().convertToXML(bpSimModel);
        return new BpSimXmlConverter().convertToBpSimModel(new InputStreamSource(new ByteArrayInputStream(xml)), true, false, "UTF-8");
    }
}
