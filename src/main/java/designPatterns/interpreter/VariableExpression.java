package designPatterns.interpreter;

public class VariableExpression implements Expression {
    private String variableName;

    public VariableExpression(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int interpret(Context context) {
        return context.getVariable(variableName);
    }
}
