package designPatterns.flyweight;

public class Program {
    public static void main(String[] args) {
        MesajPrintareFactoryFlyweight factoryMesajPrintare = new MesajPrintareFactoryFlyweight();
        ETipMesaj[] tipuriMesajePrintare = ETipMesaj.values();
        int nrTipuriMesaje = ETipMesaj.values().length;
        int random;

        for (int i = 0; i < 200; i++) {
            random = (int) (Math.random() * nrTipuriMesaje);
            Bon bon = new Bon(i, 120 + i);
            bon.printareBon(factoryMesajPrintare.getMesajPrintare(tipuriMesajePrintare[random]));
        }

        System.out.println("S-au printat " + MesajPrintareFactoryFlyweight.getNrBonuriPrintate() + " bonuri");
        System.out.println("S-au folosit " + MesajPrintareFactoryFlyweight.getNrMatriceBonuri() + " matrice printare");
    }
}
