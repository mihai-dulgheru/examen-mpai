package designPatterns.abstractFactory;

public class FactoryX implements IFactory {
    @Override
    public IPizza crearePizza() {
        return new PizzaVegetariana();
    }

    @Override
    public IBurger creareBurger() {
        return new BurgerA();
    }
}
