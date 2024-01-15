package designPatterns.chainOfResponsability;

public class Bucatar extends AHandler {
    @Override
    void procesareComanda(Comanda comanda) {
        System.out.println("Bucatarul a procesat comanda " + comanda.getProdus());
    }
}
