package designPatterns.factoryMethod;

public class PizzaVegetariana implements IPizza {
    @Override
    public void afisareDescriere() {
        System.out.println("Pizza vegetariana conține blat, sos roții, vinete.");
    }
}
