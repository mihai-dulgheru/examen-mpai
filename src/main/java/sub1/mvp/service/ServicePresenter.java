package sub1.mvp.service;

public class ServicePresenter {
    private final Service model;
    private final ServiceView view;

    public ServicePresenter(Service model, ServiceView view) {
        this.model = model;
        this.view = view;
    }

    public void setClient(String nume, String adresa, String[] angajati) {
        model.setNume(nume);
        model.setAdresa(adresa);
        model.setAngajati(angajati);
    }

    public void updateView() {
        view.afiseazaDetaliiService(model.getNume(), model.getAdresa(), model.getAngajati());
    }
}
