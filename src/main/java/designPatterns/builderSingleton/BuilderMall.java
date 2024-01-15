package designPatterns.builderSingleton;

public class BuilderMall {
    private static String lastNume;
    private static int lastId = 0;
    private static BuilderMall instance = null;
    private int id;
    private IFereastra fereastra;
    private ITerasa terasa;

    private BuilderMall() {
    }

    public static int genereazaId() {
        return ++lastId;
    }

    public static BuilderMall getInstance(String nume) {
        if (instance == null) instance = new BuilderMall();
        lastNume = nume;
        return instance;
    }

    public BuilderMall seteazaFereastra(IFereastra fereastra) {
        this.fereastra = fereastra;
        return this;
    }

    public BuilderMall seteazaTerasa(ITerasa terasa) {
        this.terasa = terasa;
        return this;
    }

    public Mall build() {
        Mall mall = new Mall(genereazaId(), lastNume, this.fereastra, this.terasa);
        this.fereastra = null;
        this.terasa = null;
        return mall;
    }
}
