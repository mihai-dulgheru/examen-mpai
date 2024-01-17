package sub2.mvc.comanda.state;

import sub2.mvc.comanda.Comanda;

public class StarePlatita extends AStare {
    public StarePlatita(Comanda comanda) {
        super(comanda);
    }

    @Override
    public void plaseazaComanda() {
        System.out.println("comanda a fost platita");
    }

    @Override
    public void preiaComanda() {
        System.out.println("comanda a fost platita");

    }

    @Override
    public void platesteComanda() {
        System.out.println("comanda a fost platita");

    }

    @Override
    public void pregatesteComanda() {
        System.out.println("comanda a fost platita");

    }
}
