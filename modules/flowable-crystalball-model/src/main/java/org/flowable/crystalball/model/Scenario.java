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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * <p>Java class for Scenario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Scenario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="ScenarioParameters" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.bpsim.org/schemas/2.0}ScenarioParameters">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ElementParameters" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.bpsim.org/schemas/2.0}ElementParameters">
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Calendar" type="{http://www.bpsim.org/schemas/2.0}Calendar" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VendorExtension" type="{http://www.bpsim.org/schemas/2.0}VendorExtension" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="author" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vendor" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="inherits" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="result" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="created" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="modified" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author martin.grofcik
 */
public class Scenario extends BpSimElement{

    protected ScenarioParameters scenarioParameters;
    protected List<ElementParameters> elementParameters;
    // todo
    //    protected List<Calendar> calendar;
    protected List<VendorExtension> vendorExtension;
    protected String id;
    protected String name;
    protected String description;
    protected String author;
    protected String vendor;
    protected String version;
    protected Object inherits;
    protected Object result;
    protected Date created;
    protected Date modified;

    public ScenarioParameters getScenarioParameters() {
        return scenarioParameters;
    }

    public void setScenarioParameters(ScenarioParameters value) {
        this.scenarioParameters = value;
    }

    public List<ElementParameters> getElementParameters() {
        if (elementParameters == null) {
            elementParameters = new ArrayList<ElementParameters>();
        }
        return this.elementParameters;
    }

    /**
     * Gets the value of the calendar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calendar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalendar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Calendar }
     * 
     * 
     */
//    public List<Calendar> getCalendar() {
//        if (calendar == null) {
//            calendar = new ArrayList<Calendar>();
//        }
//        return this.calendar;
//    }

    /**
     * Gets the value of the vendorExtension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vendorExtension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVendorExtension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VendorExtension }
     * 
     * 
     */
    public List<VendorExtension> getVendorExtension() {
        if (vendorExtension == null) {
            vendorExtension = new ArrayList<VendorExtension>();
        }
        return this.vendorExtension;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendor(String value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the inherits property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getInherits() {
        return inherits;
    }

    /**
     * Sets the value of the inherits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setInherits(Object value) {
        this.inherits = value;
    }

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setResult(Object value) {
        this.result = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link Date}
     *     
     */
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date value) {
        this.created = value;
    }

    public Date getModified() {
        return modified;
    }

    /**
     * Sets the value of the modified property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setModified(Date value) {
        this.modified = value;
    }

    public void addElementParameters(ElementParameters elementParameters) {
        this.getElementParameters().add(elementParameters);
    }
}
