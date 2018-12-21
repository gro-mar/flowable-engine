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

/**
 * @author martin.grofcik
 */
public interface BpSimXmlConstants {

    String BPSIM_NAMESPACE = "http://www.bpsim.org/schemas/2.0";
    String FLOWABLE_EXTENSIONS_NAMESPACE = "http://flowable.org/bpsim";
    String FLOWABLE_EXTENSIONS_PREFIX = "flowable";
    String XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
    String XSI_PREFIX = "xsi";

    String ATTRIBUTE_TARGET_NAMESPACE = "targetNamespace";

    String ELEMENT_BPSIM_DATA = "BPSimData";
    String ELEMENT_SCENARIO = "Scenario";
    String ELEMENT_SCENARIO_PARAMETERS = "ScenarioParameters";
    String ELEMENT_ELEMENT_PARAMETERS = "ElementParameters";
    String ELEMENT_EXTENSION_ELEMENTS = "extensionElements";
    String ELEMENT_TIME_PARAMETERS = "TimeParameters";
    String ELEMENT_PROCESSING_TIME = "ProcessingTime";
    String ELEMENT_UNIFORM_DISTRIBUTION = "UniformDistribution";

    String ATTRIBUTE_ID = "id";
    String ATTRIBUTE_NAME = "name";
    String ATTRIBUTE_DESCRIPTION = "description";
    String ATTRIBUTE_AUTHOR = "author";
    String ATTRIBUTE_VENDOR = "vendor";
    String ATTRIBUTE_VERSION = "version";
    String ATTRIBUTE_CREATED = "created";
    String ATTRIBUTE_MODIFIED = "modified";

    String ATTRIBUTE_BASE_TIME_UNIT = "baseTimeUnit";
    String ATTRIBUTE_TIME_UNIT = "timeUnit";
    String ATTRIBUTE_BASE_CURRENCY_UNIT = "baseCurrencyUnit";
    String ATTRIBUTE_REPLICATION = "replication";
    String ATTRIBUTE_SEED = "seed";
    String ATTRIBUTE_START = "start";
    String ATTRIBUTE_DURATION = "duration";

    String ATTRIBUTE_ELEMENT_REF = "elementRef";

    String ATTRIBUTE_MAX = "max";
    String ATTRIBUTE_MIN = "min";
}
