package designPatterns.abstractFactory;

public class PizzaVegetariana implements IPizza {
    @Override
    public void afisare() {
        System.out.println("Pizza vegetariana");
    }
}
