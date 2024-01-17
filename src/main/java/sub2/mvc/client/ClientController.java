package sub2.mvc.client;

public class ClientController {
    private final Client model;
    private final ClientView view;

    public ClientController(Client model, ClientView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserData(String nume, String prenume) {
        model.setNume(nume);
        model.setPrenume(prenume);
    }

    public void updateView() {
        view.printeazaDetaliiClient(model.getNume(), model.getPrenume());
    }
}
