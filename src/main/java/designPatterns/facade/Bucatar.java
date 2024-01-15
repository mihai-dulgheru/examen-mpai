package designPatterns.facade;

public class Bucatar {
    private String nume;

    public Bucatar(String nume) {
        super();
        this.nume = nume;
    }

    public boolean verificaDisponibilitate(String data) {
        return true;
    }
}
