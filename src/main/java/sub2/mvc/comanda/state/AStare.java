package sub2.mvc.comanda.state;

import sub2.mvc.comanda.Comanda;

public abstract class AStare {
    protected Comanda comanda;

    public AStare(Comanda comanda) {
        super();
        this.comanda = comanda;
    }

    public abstract void plaseazaComanda();

    public abstract void preiaComanda();

    public abstract void platesteComanda();

    public abstract void pregatesteComanda();
}
