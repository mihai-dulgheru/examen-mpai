package sub2.mvc.comanda;

public class ComandaController {
    private final Comanda model;
    private final ComandaView view;

    public ComandaController(Comanda model, ComandaView view) {
        this.model = model;
        this.view = view;
    }

    public void setComandaData(String detalii) {
        model.setDetalii(detalii);

    }

    public void updateView() {
        view.printeazaComanda(model.getStareComanda(), model.getDetalii());
    }
}
