package designPatterns.builder.v1;

public class PetrecereBuilder implements IBuilder {
    private Petrecere petrecere;

    public PetrecereBuilder() {
        petrecere = new Petrecere(0, false, false, false);
    }

    @Override
    public Petrecere build() {
        return petrecere;
    }

    public PetrecereBuilder setNrPersoane(int nrPersoane) {
        this.petrecere.setNrPersoane(nrPersoane);
        return this;
    }

    public PetrecereBuilder setAreBaloane(boolean areBaloane) {
        this.petrecere.setAreBaloane(areBaloane);
        return this;
    }

    public PetrecereBuilder setAreTort(boolean areTort) {
        this.petrecere.setAreTort(areTort);
        return this;
    }

    public PetrecereBuilder setAreArtificii(boolean areArtificii) {
        this.petrecere.setAreArtificii(areArtificii);
        return this;
    }

}
