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

import javax.xml.stream.XMLStreamWriter;

import org.flowable.crystalball.model.BpSimElement;
import org.flowable.crystalball.model.UniformDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author martin.grofcik
 */
public class UniformDistributionExporter extends AbstractExporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniformDistributionExporter.class);
    @Override
    public void export(BpSimElement bpSimElement, XMLStreamWriter xtw) throws Exception {
        if (bpSimElement instanceof UniformDistribution) {
            xtw.writeStartElement(ELEMENT_UNIFORM_DISTRIBUTION);
            UniformDistribution uniformDistribution = (UniformDistribution) bpSimElement;

            putIfNotNull(xtw, uniformDistribution.getMax(), ATTRIBUTE_MAX);
            putIfNotNull(xtw, uniformDistribution.getMin(), ATTRIBUTE_MIN);
            putIfNotNull(xtw, uniformDistribution.getTimeUnit(), ATTRIBUTE_TIME_UNIT);
        } else {
            LOGGER.warn("Unable to export {} with UniformDistributionExporter ignoring", bpSimElement);
        }
    }

}
