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
import java.util.List;

/**
 * author martin.grofcik
 */
public class ElementParameters extends BpSimElement{

    protected TimeParameters timeParameters;
// todo
//    protected ControlParameters controlParameters;
//    protected ResourceParameters resourceParameters;
//    protected PriorityParameters priorityParameters;
//    protected CostParameters costParameters;
//    protected PropertyParameters propertyParameters;
    protected List<VendorExtension> vendorExtension;
    protected String id;
    protected String elementRef;

    /**
     * Gets the value of the timeParameters property.
     * 
     * @return
     *     possible object is
     *     {@link TimeParameters }
     *     
     */
    public TimeParameters getTimeParameters() {
        return timeParameters;
    }

    /**
     * Sets the value of the timeParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeParameters }
     *     
     */
    public void setTimeParameters(TimeParameters value) {
        this.timeParameters = value;
    }

    /**
     * Gets the value of the controlParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ControlParameters }
     *     
     */
//    public ControlParameters getControlParameters() {
//        return controlParameters;
//    }

    /**
     * Sets the value of the controlParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlParameters }
     *     
     */
//    public void setControlParameters(ControlParameters value) {
//        this.controlParameters = value;
//    }

    /**
     * Gets the value of the resourceParameters property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceParameters }
     *     
     */
//    public ResourceParameters getResourceParameters() {
//        return resourceParameters;
//    }

    /**
     * Sets the value of the resourceParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceParameters }
     *     
     */
//    public void setResourceParameters(ResourceParameters value) {
//        this.resourceParameters = value;
//    }

    /**
     * Gets the value of the priorityParameters property.
     * 
     * @return
     *     possible object is
     *     {@link PriorityParameters }
     *     
     */
//    public PriorityParameters getPriorityParameters() {
//        return priorityParameters;
//    }

    /**
     * Sets the value of the priorityParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriorityParameters }
     *     
     */
//    public void setPriorityParameters(PriorityParameters value) {
//        this.priorityParameters = value;
//    }

    /**
     * Gets the value of the costParameters property.
     * 
     * @return
     *     possible object is
     *     {@link CostParameters }
     *     
     */
//    public CostParameters getCostParameters() {
//        return costParameters;
//    }

    /**
     * Sets the value of the costParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostParameters }
     *     
     */
//    public void setCostParameters(CostParameters value) {
//        this.costParameters = value;
//    }

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
//
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

    public String getElementRef() {
        return elementRef;
    }

    public void setElementRef(String value) {
        this.elementRef = value;
    }

}
