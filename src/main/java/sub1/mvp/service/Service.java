package sub1.mvp.service;

import sub1.dp.observer.IObserver;
import sub1.dp.observer.ISubiect;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service implements ISubiect {
    private static final String NUME_FISIER = "service.txt";
    private String nume;
    private String adresa;
    private String[] angajati;
    private final List<IObserver> listaObservatori;

    public Service(String nume, String adresa, String[] angajati) {
        this.nume = nume;
        this.adresa = adresa;
        this.angajati = angajati;
        this.listaObservatori = new ArrayList<>();
    }

    public static Service citire() throws IOException {
        Service service = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(NUME_FISIER))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(",");
                String nume = array[0];
                String adresa = array[1];
                String[] angajati = new String[array.length - 2];
                System.arraycopy(array, 2, angajati, 0, array.length - 2);
                service = new Service(nume, adresa, angajati);
            }
        }
        return service;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String[] getAngajati() {
        return angajati;
    }

    public void setAngajati(String[] angajati) {
        this.angajati = angajati;
    }

    @Override
    public String toString() {
        return "Service{" +
                "nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", angajati=" + Arrays.toString(angajati) +
                ", listaObservatori=" + listaObservatori +
                '}';
    }

    public void scriere() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NUME_FISIER, true))) {
            writer.write(this.nume + ',' + this.adresa + ",");
            for (int i = 0; i < this.angajati.length; i++) {
                writer.write(this.angajati[i] + ',');
            }
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        this.listaObservatori.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.listaObservatori.remove(observer);
    }

    @Override
    public void notifyAll(String mesaj) {
        for (IObserver observer : listaObservatori)
            observer.getMesaj(mesaj);
    }
}
