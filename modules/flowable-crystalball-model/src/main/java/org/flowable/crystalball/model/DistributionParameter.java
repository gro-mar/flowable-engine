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
package org.flowable.crystalball.model;

/**
 * <p>Java class for DistributionParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DistributionParameter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.bpsim.org/schemas/2.0}ParameterValue">
 *       &lt;attribute name="timeUnit" type="{http://www.bpsim.org/schemas/2.0}TimeUnit" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author martin.grofcik
 */
public class DistributionParameter
    extends ParameterValue
{

    protected TimeUnit timeUnit;

    /**
     * Gets the value of the timeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeUnit }
     *     
     */
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    /**
     * Sets the value of the timeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeUnit }
     *     
     */
    public void setTimeUnit(TimeUnit value) {
        this.timeUnit = value;
    }

}
