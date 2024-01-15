package designPatterns.decorator;

public abstract class APizza {
    private boolean esteVegana;

    abstract String getComponente();

    abstract int getPret();
}
