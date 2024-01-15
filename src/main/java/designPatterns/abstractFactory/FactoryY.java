package designPatterns.abstractFactory;

public class FactoryY implements IFactory {
    @Override
    public IPizza crearePizza() {
        return new PizzaRoma();
    }

    @Override
    public IBurger creareBurger() {
        return new BurgerB();
    }
}
