package dataModels.activeRecord;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public class Main {
    public static void main(String[] args) {
        try {
            Database.connect();

            // Citirea tuturor clienților
            List<Client> clients = Client.readMany();
            for (Client client : clients) {
                System.out.println(client);
            }

            // Adăugarea unui nou client
            Client newClient = new Client("Nume", "Prenume", "1234567890123", "Adresa", "email@example.com", "123456789", "username", "password");
            newClient.insert();

            // Citirea noului client după inserare
            Client readClient = Client.readOne(newClient.getIdClient());
            System.out.println("Clientul adăugat recent:");
            System.out.println(readClient);

            // Modificarea datelor clientului și actualizarea în baza de date
            readClient.setNumeClient("NumeModificat");
            readClient.update();

            // Citirea datelor clientului după actualizare
            Client updatedClient = Client.readOne(readClient.getIdClient());
            System.out.println("Clientul actualizat:");
            System.out.println(updatedClient);

            // Ștergerea clientului
            updatedClient.delete();

            // Citirea tuturor clienților după ștergere
            System.out.println("Clienții după ștergere:");
            List<Client> remainingClients = Client.readMany();
            for (Client client : remainingClients) {
                System.out.println(client);
            }

            Database.commit();
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            Database.rollback();
        } finally {
            Database.disconnect();
        }
    }
}
