package sub2.mvc.comanda;

import sub2.mvc.comanda.state.AStare;
import sub2.mvc.comanda.state.StarePlasata;

import java.io.Serializable;

public class Comanda implements Serializable {
    private int id;
    private AStare stareComanda;
    private String detalii;
    private int idClient;

    public Comanda(int id, String detalii, int idClient) {
        this.id = id;
        this.detalii = detalii;
        this.idClient = idClient;
        this.stareComanda = new StarePlasata(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AStare getStareComanda() {
        return stareComanda;
    }

    public void setStareComanda(AStare stareComanda) {
        this.stareComanda = stareComanda;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "comanda{" +
                "id=" + id +
                ", stareComanda=" + stareComanda +
                ", detalii='" + detalii + '\'' +
                ", idClient=" + idClient +
                '}';
    }

    @Override
    public int hashCode() {
        // return super.hashCode();
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        // return super.equals(obj);
        if (obj instanceof Comanda comanda) {
            return id == comanda.id;
        }
        return false;
    }
}
