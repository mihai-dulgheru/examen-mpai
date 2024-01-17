package sub1.main.mvp.solicitare;

import sub1.main.mvp.client.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solicitare {
    private static final String NUME_FISIER = "solicitari.txt";
    private String problema;
    private String loc;
    private Client client;

    public Solicitare(String problema, String loc, Client client) {
        this.problema = problema;
        this.loc = loc;
        this.client = client;
    }

    public static List<Solicitare> citire() throws IOException {
        List<Solicitare> solicitari = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NUME_FISIER))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String problema = line.split(",")[0];
                String loc = line.split(",")[1];
                Client client = new Client(line.split(",")[2], line.split(",")[3]);
                solicitari.add(new Solicitare(problema, loc, client));
            }
        }
        return solicitari;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Solicitare{" +
                "problema='" + problema + '\'' +
                ", loc='" + loc + '\'' +
                ", client=" + client +
                '}';
    }

    public void scriere() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NUME_FISIER, true))) {
            writer.write(this.problema + ',' + this.loc + "," + this.getClient().getNume() + "," + this.client.getPrenume());
        }
    }
}
