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
 * <p>Java class for TimeUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TimeUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ms"/>
 *     &lt;enumeration value="s"/>
 *     &lt;enumeration value="min"/>
 *     &lt;enumeration value="hour"/>
 *     &lt;enumeration value="day"/>
 *     &lt;enumeration value="year"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum TimeUnit {

    MS("ms"),
    S("s"),
    MIN("min"),
    HOUR("hour"),
    DAY("day"),
    YEAR("year");

    private final String value;

    TimeUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TimeUnit fromValue(String v) {
        if (v == null) {
            return null;
        }
        for (TimeUnit c: TimeUnit.values()) {
            if (c.value.equalsIgnoreCase(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
