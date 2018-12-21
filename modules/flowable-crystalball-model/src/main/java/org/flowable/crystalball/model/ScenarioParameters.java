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
 * <p>Java class for ScenarioParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScenarioParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="Start" type="{http://www.bpsim.org/schemas/2.0}Parameter" minOccurs="0"/>
 *         &lt;element name="Duration" type="{http://www.bpsim.org/schemas/2.0}Parameter" minOccurs="0"/>
 *         &lt;element name="Warmup" type="{http://www.bpsim.org/schemas/2.0}Parameter" minOccurs="0"/>
 *         &lt;element name="PropertyParameters" type="{http://www.bpsim.org/schemas/2.0}PropertyParameters" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="replication" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="seed" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="baseTimeUnit" type="{http://www.bpsim.org/schemas/2.0}TimeUnit" default="min" />
 *       &lt;attribute name="baseCurrencyUnit" type="{http://www.w3.org/2001/XMLSchema}string" default="USD" />
 *       &lt;attribute name="baseResultFrequency" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="baseResultFrequencyCumul" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="traceOutput" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="traceFormat" type="{http://www.w3.org/2001/XMLSchema}string" default="XES" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 * @author martin.grofcik
 * 
 */
public class ScenarioParameters extends BpSimElement {

    protected Parameter start;
    protected Parameter duration;
    protected Parameter warmup;
// todo
//    protected PropertyParameters propertyParameters;
    protected Integer replication;
    protected Long seed;
    protected TimeUnit baseTimeUnit;
    protected String baseCurrencyUnit;
// todo
//    protected Duration baseResultFrequency;
    protected Boolean baseResultFrequencyCumul;
    protected Boolean traceOutput;
    protected String traceFormat;

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link Parameter }
     *     
     */
    public Parameter getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameter }
     *     
     */
    public void setStart(Parameter value) {
        this.start = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Parameter }
     *     
     */
    public Parameter getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameter }
     *     
     */
    public void setDuration(Parameter value) {
        this.duration = value;
    }

    /**
     * Gets the value of the warmup property.
     * 
     * @return
     *     possible object is
     *     {@link Parameter }
     *     
     */
    public Parameter getWarmup() {
        return warmup;
    }

    /**
     * Sets the value of the warmup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parameter }
     *     
     */
    public void setWarmup(Parameter value) {
        this.warmup = value;
    }

    /**
     * Gets the value of the propertyParameters property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyParameters }
     *     
     */
//    public PropertyParameters getPropertyParameters() {
//        return propertyParameters;
//    }

    /**
     * Sets the value of the propertyParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyParameters }
     *     
     */
//    public void setPropertyParameters(PropertyParameters value) {
//        this.propertyParameters = value;
//    }

    /**
     * Gets the value of the replication property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReplication() {
        return replication;
    }

    /**
     * Sets the value of the replication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReplication(Integer value) {
        this.replication = value;
    }

    /**
     * Gets the value of the seed property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSeed() {
        return seed;
    }

    /**
     * Sets the value of the seed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSeed(Long value) {
        this.seed = value;
    }

    /**
     * Gets the value of the baseTimeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeUnit }
     *     
     */
    public TimeUnit getBaseTimeUnit() {
        if (baseTimeUnit == null) {
            return TimeUnit.MIN;
        } else {
            return baseTimeUnit;
        }
    }

    /**
     * Sets the value of the baseTimeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeUnit }
     *     
     */
    public void setBaseTimeUnit(TimeUnit value) {
        this.baseTimeUnit = value;
    }

    /**
     * Gets the value of the baseCurrencyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseCurrencyUnit() {
        if (baseCurrencyUnit == null) {
            return "USD";
        } else {
            return baseCurrencyUnit;
        }
    }

    /**
     * Sets the value of the baseCurrencyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseCurrencyUnit(String value) {
        this.baseCurrencyUnit = value;
    }

    /**
     * Gets the value of the baseResultFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
//    public Duration getBaseResultFrequency() {
//        return baseResultFrequency;
//    }

    /**
     * Sets the value of the baseResultFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
//    public void setBaseResultFrequency(Duration value) {
//        this.baseResultFrequency = value;
//    }

    /**
     * Gets the value of the baseResultFrequencyCumul property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isBaseResultFrequencyCumul() {
        if (baseResultFrequencyCumul == null) {
            return false;
        } else {
            return baseResultFrequencyCumul;
        }
    }

    /**
     * Sets the value of the baseResultFrequencyCumul property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBaseResultFrequencyCumul(Boolean value) {
        this.baseResultFrequencyCumul = value;
    }

    /**
     * Gets the value of the traceOutput property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTraceOutput() {
        if (traceOutput == null) {
            return false;
        } else {
            return traceOutput;
        }
    }

    /**
     * Sets the value of the traceOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTraceOutput(Boolean value) {
        this.traceOutput = value;
    }

    /**
     * Gets the value of the traceFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraceFormat() {
        if (traceFormat == null) {
            return "XES";
        } else {
            return traceFormat;
        }
    }

    /**
     * Sets the value of the traceFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraceFormat(String value) {
        this.traceFormat = value;
    }

}
