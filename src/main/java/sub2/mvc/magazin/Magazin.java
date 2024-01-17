package sub2.mvc.magazin;

import java.util.List;

public class Magazin {
    List<Integer> listaComenzi;
    private String denumire;

    public Magazin(String denumire, List<Integer> listaComenzi) {
        this.denumire = denumire;
        this.listaComenzi = listaComenzi;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public List<Integer> getListaComenzi() {
        return listaComenzi;
    }

    public void setListaComenzi(List<Integer> listaComenzi) {
        this.listaComenzi = listaComenzi;
    }
}
