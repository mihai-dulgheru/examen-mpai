package designPatterns.builder.v3;

public class Program {
    public static void main(String[] args) {
        Petrecere petrecere = Petrecere.builder().setAreArtificii(true).setAreBaloane(true).setNrPersoane(20).build();
        System.out.println(petrecere);

        Petrecere petrecere2 = new Petrecere.PetrecereBuilder().setAreArtificii(true).build();
        System.out.println(petrecere2);
    }
}
