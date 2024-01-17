package dataModels.activeRecord.file;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            // Crearea unui nou client
            Client newClient = new Client("Ion", "Popescu", "1234567890123", "Str. Libertății, Nr. 10", "ion.popescu@email.com", "0740123456", "ionpopescu", "parola123");
            newClient.insert();
            System.out.println("Clientul a fost inserat.");

            // Citirea și afișarea tuturor clienților
            List<Client> clients = Client.readMany();
            System.out.println("Lista clienților:");
            for (Client client : clients) {
                System.out.println(client);
            }

            // Actualizarea unui client
            UUID idClient = newClient.getIdClient(); // Salvăm ID-ul clientului inserat
            Client clientToUpdate = Client.readOne(idClient);
            if (clientToUpdate != null) {
                clientToUpdate.setNumeClient("Mihai");
                clientToUpdate.update();
                System.out.println("Clientul a fost actualizat.");
            }

            // Citirea și afișarea tuturor clienților
            clients = Client.readMany();
            System.out.println("Lista clienților:");
            for (Client client : clients) {
                System.out.println(client);
            }

            // Ștergerea unui client
            Client clientToDelete = Client.readOne(idClient);
            if (clientToDelete != null) {
                clientToDelete.delete();
                System.out.println("Clientul a fost șters.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
