package sub2.mvc.magazin;

import java.util.List;

public class MagazinView {
    public void printeazaDetaliiMagazin(String denumire, List<Integer> listaComenzi) {
        System.out.println("Denumire " + denumire);
        System.out.println("ListaComenzi");
        for (Integer i : listaComenzi) {
            System.out.println("comanda cu id-ul: " + i);
        }
    }
}
