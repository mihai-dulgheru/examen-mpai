package designPatterns.decorator;

public class Program {
    public static void main(String[] args) {
        APizza pizza = new PizzaVegetariana();
        System.out.println(pizza.getComponente());
        System.out.println(pizza.getPret());
        APizza pizzaVegetarianaCrown = new DecoratorCrown(pizza);
        System.out.println(pizzaVegetarianaCrown.getComponente());
        System.out.println(pizzaVegetarianaCrown.getPret());
    }
}
