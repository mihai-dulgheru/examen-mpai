package designPatterns.interpreter;

import java.util.HashMap;

public class Context {
    private HashMap<String, Integer> variables = new HashMap<>();

    public void setVariable(String variableName, int value) {
        variables.put(variableName, value);
    }

    public int getVariable(String variableName) {
        return variables.getOrDefault(variableName, 0);
    }
}
