package designPatterns.prototype;

import java.util.ArrayList;

public abstract class AContract implements Cloneable {
    protected String tip;
    protected ArrayList<String> listaClauze;
    private String id;

    public void modifListaClauze(int i, String clauzaNoua) {
        listaClauze.set(i, clauzaNoua);
    }

    abstract void printare();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public ArrayList<String> getListaClauze() {
        return listaClauze;
    }

    @Override
    public String toString() {
        return "AContract{" +
                "tip='" + tip + '\'' +
                ", listaClauze=" + listaClauze +
                ", id='" + id + '\'' +
                '}';
    }

    @SuppressWarnings("CallToPrintStackTrace")
    @Override
    public AContract clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return (AContract) clone;
    }
}
