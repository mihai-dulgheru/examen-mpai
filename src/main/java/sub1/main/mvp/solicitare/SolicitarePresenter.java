package sub1.main.mvp.solicitare;

import sub1.main.mvp.client.Client;

public class SolicitarePresenter {
    private final Solicitare model;
    private final SolicitareView view;

    public SolicitarePresenter(Solicitare model, SolicitareView view) {
        this.model = model;
        this.view = view;
    }

    public void setSolicitare(String problema, String loc, Client client) {
        model.setProblema(problema);
        model.setLoc(loc);
        model.setClient(client);
    }

    public void updateView() {
        view.afiseazaDetaliiSolicitare(model.getProblema(), model.getLoc(), model.getClient());
    }
}
