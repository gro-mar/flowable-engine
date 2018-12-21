
package org.flowable.crystalball.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author martin.grofcik
 */
public class BpSimModel {

    protected String targetNamespace;
    protected Map<String, String> namespaceMap = new LinkedHashMap<>();

    protected Map<String, Scenario> scenarios = new HashMap<>();

    public Collection<Scenario> getScenarios() {
        return this.scenarios.values();
    }

    public Scenario getScenarioById(String scenarioId) {
        return scenarios.get(scenarioId);
    }

    public void addScenario(String id, Scenario scenario) {
        scenarios.put(id, scenario);
    }

    public void addNamespace(String prefix, String uri) {
        namespaceMap.put(prefix, uri);
    }
    public boolean containsNamespacePrefix(String prefix) {
        return namespaceMap.containsKey(prefix);
    }
    public String getNamespace(String prefix) {
        return namespaceMap.get(prefix);
    }
    public Map<String, String> getNamespaces() {
        return namespaceMap;
    }
    public String getTargetNamespace() {
        return targetNamespace;
    }
    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

}
