package designPatterns.singleton;

public class Program {
    public static void main(String[] args) throws Exception {
        Ospatar ospatar1 = new Ospatar("Gigel");
        Ospatar ospatar2 = new Ospatar("Costel");

        // validare implementare singleton
        if (ospatar1.getRestaurant() == ospatar2.getRestaurant()) {
            System.out.println("Referinte identice");
        } else {
            System.out.println("Referintele nu sunt identice");
        }

        ospatar1.preiaClient(2);
        System.out.println(ospatar1.getRestaurant());
        System.out.println(ospatar2.getRestaurant());

        ospatar2.preiaClient(5);
        System.out.println(ospatar1.getRestaurant());
        System.out.println(ospatar2.getRestaurant());
    }
}
