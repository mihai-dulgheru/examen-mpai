package designPatterns.singleton;

import java.util.Arrays;

public class Restaurant {
    private static Restaurant instance = null;

    // date stocate la nivel de restaurant
    private int nrMese = 10;
    private boolean ocupareMese[] = new boolean[nrMese];

    private Restaurant() throws Exception {
        if (instance != null) {
            throw new Exception("Obj deja creat!");
        }
    }

    public static Restaurant getInstance() throws Exception {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    // alte metode
    public void setOcupareMasa(int i) {
        if (i >= 0 && i < nrMese && ocupareMese[i] == false) ocupareMese[i] = true;
    }

    public void setEliberareMasa(int i) {
        if (i >= 0 && i < nrMese && ocupareMese[i] == true) ocupareMese[i] = false;
    }

    @Override
    public String toString() {
        return "Restaurant [nrMese=" + nrMese + ", ocupareMese=" + Arrays.toString(ocupareMese) + "]";
    }
}
