package sub1.main.mvp.service;

import java.util.Arrays;

public class ServiceViewImpl implements ServiceView {
    @Override
    public void afiseazaDetaliiService(String nume, String adresa, String[] angajati) {
        System.out.println("Nume: " + nume);
        System.out.println("Adresa: " + adresa);
        System.out.println("Angajati: " + Arrays.stream(angajati));
    }
}
