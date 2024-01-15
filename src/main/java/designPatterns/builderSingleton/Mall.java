package designPatterns.builderSingleton;

public class Mall {
    private int id;
    private String nume;
    private IFereastra fereastra;
    private ITerasa terasa;

    Mall(int id, String nume, IFereastra fereastra, ITerasa terasa) {
        super();
        this.id = id;
        this.nume = nume;
        this.fereastra = fereastra;
        this.terasa = terasa;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    void setNume(String nume) {
        this.nume = nume;
    }

    public IFereastra getFereastra() {
        return fereastra;
    }

    void setFereastra(IFereastra fereastra) {
        this.fereastra = fereastra;
    }

    public ITerasa getTerasa() {
        return terasa;
    }

    void setTerasa(ITerasa terasa) {
        this.terasa = terasa;
    }

    @Override
    public String toString() {
        return "Mall [id=" + id + ", nume=" + nume + ", fereastra=" + fereastra + ", terasa=" + terasa + "]";
    }

    public void intretinereMall() {
        System.out.println("Curatare mall " + this.nume + ", id " + this.id);
        if (this.fereastra != null) fereastra.curatareFereastra();
        if (this.terasa != null) terasa.curatareTerasa();
    }
}
