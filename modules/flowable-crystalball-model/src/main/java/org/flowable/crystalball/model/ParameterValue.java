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

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ParameterValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="validFor" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="instance" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="result" type="{http://www.bpsim.org/schemas/2.0}ResultType" />
 *       &lt;attribute name="resultTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author martin.grofcik
 */
public class ParameterValue extends BpSimElement {

    protected Object validFor;
    protected String instance;
// todo
//    protected ResultType result;
    protected Date resultTimeStamp;

    /**
     * Gets the value of the validFor property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getValidFor() {
        return validFor;
    }

    /**
     * Sets the value of the validFor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setValidFor(Object value) {
        this.validFor = value;
    }

    /**
     * Gets the value of the instance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstance() {
        return instance;
    }

    /**
     * Sets the value of the instance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstance(String value) {
        this.instance = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
//    public ResultType getResult() {
//        return result;
//    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
//    public void setResult(ResultType value) {
//        this.result = value;
//    }

    /**
     * Gets the value of the resultTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getResultTimeStamp() {
        return resultTimeStamp;
    }

    /**
     * Sets the value of the resultTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setResultTimeStamp(Date value) {
        this.resultTimeStamp = value;
    }

}
