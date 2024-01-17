package dataModels.activeRecord.db;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    static {
        try {
            Database.statement.executeUpdate("CREATE TABLE IF NOT EXISTS clienti" +
                    "(" +
                    "    id_client      VARCHAR(36) PRIMARY KEY," +
                    "    nume_client    VARCHAR(255) NOT NULL," +
                    "    prenume_client VARCHAR(255) NOT NULL," +
                    "    cnp            VARCHAR(255) NOT NULL," +
                    "    adresa         VARCHAR(255) NOT NULL," +
                    "    email          VARCHAR(255) NOT NULL," +
                    "    telefon        VARCHAR(255) NOT NULL," +
                    "    username       VARCHAR(255) NOT NULL," +
                    "    parola         VARCHAR(255) NOT NULL" +
                    ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final UUID idClient;
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

    public static Client readOne(UUID idClient) throws SQLException {
        String selectString = "SELECT * FROM clienti WHERE id_client = ?";
        PreparedStatement selectClient = Database.connection.prepareStatement(selectString);

        selectClient.setString(1, idClient.toString());

        ResultSet rs = selectClient.executeQuery();
        return load(rs);
    }

    public static List<Client> readMany() throws SQLException {
        ResultSet rs = Database.statement.executeQuery("SELECT * FROM clienti");

        List<Client> clients = new ArrayList<>();
        while (rs.next()) {
            clients.add(load(rs));
        }

        return clients;
    }

    protected static Client load(ResultSet resultSet) throws SQLException {
        UUID id = UUID.fromString(resultSet.getString(1));
        String numeClient = resultSet.getString(2);
        String prenumeClient = resultSet.getString(3);
        String cnp = resultSet.getString(4);
        String adresa = resultSet.getString(5);
        String email = resultSet.getString(6);
        String telefon = resultSet.getString(7);
        String username = resultSet.getString(8);
        String parola = resultSet.getString(9);

        return new Client(id, numeClient, prenumeClient, cnp, adresa, email, telefon, username, parola);
    }

    public void insert() throws SQLException {
        String insertString = "INSERT INTO clienti VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertClient = Database.connection.prepareStatement(insertString);

        insertClient.setString(1, this.idClient.toString());
        insertClient.setString(2, this.numeClient);
        insertClient.setString(3, this.prenumeClient);
        insertClient.setString(4, this.cnp);
        insertClient.setString(5, this.adresa);
        insertClient.setString(6, this.email);
        insertClient.setString(7, this.telefon);
        insertClient.setString(8, this.username);
        insertClient.setString(9, this.parola);

        insertClient.executeUpdate();
    }

    public void update() throws SQLException {
        String updateString = "UPDATE clienti SET nume_client = ?, prenume_client = ?, cnp = ?, adresa = ?, email = ?, telefon = ?, username = ?, parola = ? WHERE id_client = ?";
        PreparedStatement updateClient = Database.connection.prepareStatement(updateString);

        updateClient.setString(1, this.numeClient);
        updateClient.setString(2, this.prenumeClient);
        updateClient.setString(3, this.cnp);
        updateClient.setString(4, this.adresa);
        updateClient.setString(5, this.email);
        updateClient.setString(6, this.telefon);
        updateClient.setString(7, this.username);
        updateClient.setString(8, this.parola);
        updateClient.setString(9, this.idClient.toString());

        updateClient.executeUpdate();
    }

    public void delete() throws SQLException {
        String deleteString = "DELETE FROM clienti WHERE id_client = ?";
        PreparedStatement deleteClient = Database.connection.prepareStatement(deleteString);

        deleteClient.setString(1, this.idClient.toString());

        deleteClient.executeUpdate();
    }

    public UUID getIdClient() {
        return idClient;
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
