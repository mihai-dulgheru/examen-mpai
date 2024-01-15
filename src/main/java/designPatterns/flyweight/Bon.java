package designPatterns.flyweight;

public class Bon implements IPrintabil {
    private int nrMasa;
    private float costTotal;

    public Bon(int nrMasa, float costTotal) {
        super();
        this.nrMasa = nrMasa;
        this.costTotal = costTotal;
    }

    @Override
    public void printareBon(MesajPrintare mesajPrintare) {
        System.out.println("Pentru printare s-a folosit formatul " + mesajPrintare.getTipMesaj());
        System.out.println("Bonul de la masa " + this.nrMasa + ", cost total: " + this.costTotal);
    }
}
