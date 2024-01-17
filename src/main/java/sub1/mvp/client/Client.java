package sub1.mvp.client;

import sub1.dp.observer.IObserver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client implements IObserver {
    private static final String NUME_FISIER = "clients.txt";
    private String nume;
    private String prenume;

    public Client(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public static List<Client> citire() throws IOException {
        List<Client> clienti = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NUME_FISIER))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String nume = line.split(",")[0];
                String prenume = line.split(",")[1];
                clienti.add(new Client(nume, prenume));
            }
        }
        return clienti;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }

    public void scriere() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NUME_FISIER, true))) {
            writer.write(this.nume + ',' + this.prenume);
        }
    }

    public void update(Client clientNou) {
        try {
            List<Client> clienti = Client.citire();
            Client clientVechi = null;
            for (Client c : clienti) {
                if (c.getNume().equalsIgnoreCase(this.nume)) {
                    clientVechi = c;
                    break;
                }
            }
            if (clientVechi == null) {
                throw new Exception("Clientul nu exista");
            }
            clientVechi.setNume(clientNou.getNume());
            clientVechi.setPrenume(clientNou.getPrenume());
            File myObj = new File(NUME_FISIER);
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                throw new Exception("Failed to delete the file.");
            }
            for (Client client : clienti) {
                client.scriere();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insert() {
        try {
            this.scriere();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete() {
        try {
            List<Client> clienti = Client.citire();
            Client clientVechi = null;
            for (Client c : clienti) {
                if (c.getNume().equalsIgnoreCase(this.nume)) {
                    clientVechi = c;
                    break;
                }
            }
            if (clientVechi == null) {
                throw new Exception("Clientul nu exista");
            }
            clienti.remove(clientVechi);
            File myObj = new File(NUME_FISIER);
            if (myObj.delete()) {
                System.out.println("Deleted the file: " + myObj.getName());
            } else {
                throw new Exception("Failed to delete the file.");
            }
            for (Client client : clienti) {
                client.scriere();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getMesaj(String mesaj) {
        System.out.println("Stadiul interventiei este: " + mesaj);
    }
}
