package sub2.mvc.magazin;

import java.util.List;

public class MagazinController {
    private final Magazin model;
    private final MagazinView view;

    public MagazinController(Magazin model, MagazinView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserData(String denumire, List<Integer> listaComezni) {
        model.setDenumire(denumire);
        model.setListaComenzi(listaComezni);
    }

    public void updateView() {
        view.printeazaDetaliiMagazin(model.getDenumire(), model.getListaComenzi());
    }
}
