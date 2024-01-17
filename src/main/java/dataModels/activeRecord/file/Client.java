package dataModels.activeRecord.file;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Client {
    private UUID idClient;
    private String numeClient;
    private String prenumeClient;
    private String cnp;
    private String adresa;
    private String email;
    private String telefon;
    private String username;
    private String parola;

    public Client() {
        this.idClient = UUID.randomUUID();
    }

    public Client(String numeClient, String prenumeClient, String cnp, String adresa, String email, String telefon, String username, String parola) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this();
        this.numeClient = numeClient;
        this.prenumeClient = prenumeClient;
        this.cnp = cnp;
        this.adresa = adresa;
        this.email = email;
        this.telefon = telefon;
        this.username = username;
        this.parola = parola;
    }

    private Client(UUID idClient, String numeClient, String prenumeClient, String cnp, String adresa, String email, String telefon, String username, String parola) {
        this.idClient = idClient;
        this.numeClient = numeClient;
        this.prenumeClient = prenumeClient;
        this.cnp = cnp;
        this.adresa = adresa;
        this.email = email;
        this.telefon = telefon;
        this.username = username;
        this.parola = parola;
    }

    public void insert() throws IOException {
        String clientData = String.join(",",
                this.idClient.toString(),
                this.numeClient,
                this.prenumeClient,
                this.cnp,
                this.adresa,
                this.email,
                this.telefon,
                this.username,
                this.parola);

        FileManager.appendLine(clientData);
    }

    public void update() throws IOException {
        List<String> lines = FileManager.readAllLines();
        List<String> updatedLines = lines.stream().map(line -> {
            String[] data = line.split(",");
            if (data[0].equals(this.idClient.toString())) {
                return String.join(",",
                        this.idClient.toString(),
                        this.numeClient,
                        this.prenumeClient,
                        this.cnp,
                        this.adresa,
                        this.email,
                        this.telefon,
                        this.username,
                        this.parola);
            }
            return line;
        }).collect(Collectors.toList());

        FileManager.writeAllLines(updatedLines);
    }

    public static List<Client> readMany() throws IOException {
        List<String> lines = FileManager.readAllLines();
        return lines.stream().map(Client::parseFromCSV).collect(Collectors.toList());
    }

    public static Client readOne(UUID idClient) throws IOException {
        List<Client> clients = readMany();
        return clients.stream().filter(c -> c.getIdClient().equals(idClient)).findFirst().orElse(null);
    }

    private static Client parseFromCSV(String csv) {
        String[] data = csv.split(",");
        return new Client(UUID.fromString(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);
    }

    public void delete() throws IOException {
        List<String> lines = FileManager.readAllLines();
        List<String> updatedLines = lines.stream()
                .filter(line -> !line.startsWith(this.idClient.toString()))
                .collect(Collectors.toList());

        FileManager.writeAllLines(updatedLines);
    }

    public UUID getIdClient() {
        return idClient;
    }

    public void setIdClient(UUID idClient) {
        this.idClient = idClient;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getPrenumeClient() {
        return prenumeClient;
    }

    public void setPrenumeClient(String prenumeClient) {
        this.prenumeClient = prenumeClient;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", numeClient='" + numeClient + '\'' +
                ", prenumeClient='" + prenumeClient + '\'' +
                ", cnp='" + cnp + '\'' +
                ", adresa='" + adresa + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
