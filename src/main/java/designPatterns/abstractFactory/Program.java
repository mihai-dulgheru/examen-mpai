package designPatterns.abstractFactory;

public class Program {
    public static void main(String[] args) {
        IFactory factory = new FactoryX();
        IPizza pizza = factory.crearePizza();
        pizza.afisare();
    }
}
