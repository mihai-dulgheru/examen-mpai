package dataModels.rowDataGateway.file;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Crearea și inserarea unui nou produs
            ProductRowGateway newProduct = new ProductRowGateway(1); // Presupunând că ID-ul 1 este disponibil
            newProduct.setName("Laptop");
            newProduct.setPrice(1000.00);
            newProduct.insert();
            System.out.println("Produsul a fost inserat.");

            // Căutarea și actualizarea unui produs
            ProductRowGateway existingProduct = new ProductRowGateway(1);
            System.out.println("Produsul găsit: " + existingProduct.getName() + ", Preț: " + existingProduct.getPrice());
            existingProduct.setPrice(950.00);
            existingProduct.update();
            System.out.println("Prețul produsului a fost actualizat.");

            // Ștergerea unui produs
            existingProduct.delete();
            System.out.println("Produsul a fost șters.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
