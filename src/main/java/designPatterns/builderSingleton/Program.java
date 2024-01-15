package designPatterns.builderSingleton;

public class Program {
    public static void main(String[] args) {
        Mall mall1 = BuilderMall.getInstance("Lujerului").seteazaFereastra(new FereastraB()).seteazaTerasa(new TerasaParter()).build();
        Mall mall2 = BuilderMall.getInstance("ParkLake").seteazaFereastra(new FereastraA()).build();
        System.out.println(mall1);
        System.out.println(mall2);
        mall1.intretinereMall();
        mall2.intretinereMall();
    }
}
