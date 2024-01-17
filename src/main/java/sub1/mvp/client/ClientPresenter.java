package sub1.mvp.client;

public class ClientPresenter {
    private final Client model;
    private final ClientView view;

    public ClientPresenter(Client model, ClientView view) {
        this.model = model;
        this.view = view;
    }

    public Client getClient() {
        return this.model;
    }

    public void setClient(String nume, String prenume) {
        model.setNume(nume);
        model.setPrenume(prenume);
    }

    public void updateView() {
        view.afiseazaDetaliiClient(model.getNume(), model.getPrenume());
    }
}
