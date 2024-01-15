package designPatterns.interpreter;

public class Program {
    public static void main(String[] args) {
        // Creare de variabile și constante
        Context context = new Context();
        context.setVariable("a", 5);
        context.setVariable("b", 10);

        // Construirea expresiilor
        Expression expression1 = new AddExpression(new VariableExpression("a"), new ConstantExpression(2));
        Expression expression2 = new AddExpression(new VariableExpression("b"), new ConstantExpression(5));

        // Evaluarea expresiilor
        int result1 = expression1.interpret(context);
        int result2 = expression2.interpret(context);

        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
    }
}
