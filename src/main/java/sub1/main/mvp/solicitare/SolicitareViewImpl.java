package sub1.main.mvp.solicitare;

import sub1.main.mvp.client.Client;

public class SolicitareViewImpl implements SolicitareView {
    @Override
    public void afiseazaDetaliiSolicitare(String problema, String loc, Client client) {
        System.out.println("Problema: " + problema);
        System.out.println("Loc: " + loc);
        System.out.println("Client: " + client.getNume() + " " + client.getPrenume());
    }
}
