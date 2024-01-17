package sub2.mvc.comanda;

import sub2.mvc.comanda.state.AStare;

public class ComandaView {
    public void printeazaComanda(AStare stare, String detalii) {
        System.out.println("Detalii comanda");
        System.out.println("stare: " + stare.toString());
        System.out.println("detalii:" + detalii);
    }
}
