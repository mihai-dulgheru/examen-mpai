package designPatterns.builder.v2;

public class Program {
    public static void main(String[] args) {
        PetrecereBuilder builder = new PetrecereBuilder();
        Petrecere petrecere = builder.setAreArtificii(true).setNrPersoane(200).build();
        System.out.println(petrecere);
    }
}
