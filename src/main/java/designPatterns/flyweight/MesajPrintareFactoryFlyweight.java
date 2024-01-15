package designPatterns.flyweight;

import java.util.HashMap;

public class MesajPrintareFactoryFlyweight {
    private static HashMap<ETipMesaj, MesajPrintare> listaMesaje = new HashMap<ETipMesaj, MesajPrintare>();
    private static int nrBonuriPrintate = 0;

    public static int getNrBonuriPrintate() {
        return nrBonuriPrintate;
    }

    public static int getNrMatriceBonuri() {
        return listaMesaje.size();
    }

    public MesajPrintare getMesajPrintare(ETipMesaj tipMesaj) {
        nrBonuriPrintate++;
        MesajPrintare mesajPrintare = listaMesaje.get(tipMesaj);
        if (mesajPrintare == null) {
            mesajPrintare = new MesajPrintare(tipMesaj);
            // preluare dintr-un fisier sau o BD a mesajului aferent tipMesaj
            listaMesaje.put(tipMesaj, mesajPrintare);
        }
        return mesajPrintare;
    }
}
