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
 * <p>Java class for Parameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Parameter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="ResultRequest" type="{http://www.bpsim.org/schemas/2.0}ResultType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.bpsim.org/schemas/2.0}ParameterValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * @author martin.grofcik
 */
public class Parameter extends BpSimElement {
// todo
//    protected List<ResultType> resultRequest;
    protected List<ParameterValue> parameterValue;

    /**
     * Gets the value of the resultRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResultType }
     * 
     * 
     */
//    public List<ResultType> getResultRequest() {
//        if (resultRequest == null) {
//            resultRequest = new ArrayList<ResultType>();
//        }
//        return this.resultRequest;
//    }

    /**
     * Gets the value of the parameterValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterValue property.
     *
     */
    public List<ParameterValue> getParameterValue() {
        return this.parameterValue;
    }

    public void addParameterValue(ParameterValue parameterValue) {
        if (this.parameterValue == null) {
            this.parameterValue = new ArrayList<>();
        }
        this.parameterValue.add(parameterValue);
    }
}
