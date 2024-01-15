package designPatterns.chainOfResponsability;

public class Program {
    public static void main(String[] args) {
        Ospatar ospatar = new Ospatar();
        Bucatar bucatar = new Bucatar();

        ospatar.setNextHandler(bucatar);

        Comanda comanda1 = new Comanda("Pizza", 2, 15);
        Comanda comanda2 = new Comanda("Bautura", 1, 3);
        Comanda comanda3 = new Comanda("Cafea", 1, 4);

        System.out.println("COMANDA 1");
        ospatar.procesareComanda(comanda1);

        System.out.println("\nCOMANDA 2");
        ospatar.procesareComanda(comanda2);

        System.out.println("\nCOMANDA 3");
        ospatar.procesareComanda(comanda3);
    }
}
