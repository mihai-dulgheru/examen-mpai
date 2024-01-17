package sub1.main.mvp.client;

public class ClientViewImpl implements ClientView {
    @Override
    public void afiseazaDetaliiClient(String nume, String prenume) {
        System.out.println("Nume: " + nume);
        System.out.println("Prenume: " + prenume);
    }
}
