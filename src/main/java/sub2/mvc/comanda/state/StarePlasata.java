package sub2.mvc.comanda.state;

import sub2.mvc.comanda.Comanda;

public class StarePlasata extends AStare {
    public StarePlasata(Comanda comanda) {
        super(comanda);
    }

    @Override
    public void plaseazaComanda() {
        System.out.println("comanda a fost plasata");
    }

    @Override
    public void preiaComanda() {
        System.out.println("comanda nu poate fi preluata. comanda este in stare plasata");
    }

    @Override
    public void platesteComanda() {
        System.out.println("comanda nu poate fi platita. Este in starea plasata");
    }

    @Override
    public void pregatesteComanda() {
        System.out.println("comanda nu poate fi pregatita. Este in starea plasata");
    }
}
