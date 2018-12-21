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

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.flowable.crystalball.model.BpSimModel;
import org.flowable.crystalball.model.ElementParameters;
import org.flowable.crystalball.model.ParameterValue;
import org.flowable.crystalball.model.Scenario;
import org.flowable.crystalball.model.TimeParameters;
import org.flowable.crystalball.model.TimeUnit;
import org.flowable.crystalball.model.UniformDistribution;
import org.junit.Test;

/**
 * @author martin.grofcik
 */
public class TimeParametersXmlConverterTest extends AbstractConverterTest {

    private static final String BPSIM_RESOURCE = "org/flowable/test/crystalball/converter/TimeParameters.bpsim.xml";

    @Test
    public void convertXMLToModel() throws Exception {
        BpSimModel bpSimModel = readXMLFile(BPSIM_RESOURCE);
        validateModel(bpSimModel);
    }

    @Test
    public void convertModelToXML() throws Exception {
        BpSimModel bpSimModel = readXMLFile(BPSIM_RESOURCE);
        BpSimModel parsedModel = exportAndReadXMLFile(bpSimModel);
        validateModel(parsedModel);
    }

    public void validateModel(BpSimModel bpSimModel) {
        assertNotNull(bpSimModel);
        assertEquals(1, bpSimModel.getScenarios().size());

        // Scenario
        Scenario scenario = bpSimModel.getScenarios().iterator().next();
        List<ElementParameters> elementParameters = scenario.getElementParameters();

        assertThat(elementParameters.size(), is(1));
        TimeParameters timeParameters = elementParameters.get(0).getTimeParameters();
        assertThat(timeParameters.getProcessingTime().getParameterValue().size(), is(1));
        ParameterValue parameterValue = timeParameters.getProcessingTime().getParameterValue().get(0);
        assertThat(parameterValue, instanceOf(UniformDistribution.class));
        UniformDistribution uniformDistribution = (UniformDistribution) parameterValue;
        assertThat(uniformDistribution.getMin(), is(1d));
        assertThat(uniformDistribution.getMax(), is(2d));
        assertThat(uniformDistribution.getTimeUnit(), is(TimeUnit.DAY));
    }

}
