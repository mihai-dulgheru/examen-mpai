package designPatterns.state;

public abstract class AStare {
    protected Bucatar bucatar;

    public AStare(Bucatar bucatar) {
        super();
        this.bucatar = bucatar;
    }

    public abstract void preiaComanda(String comanda);

    public abstract void iaPauza();
}
