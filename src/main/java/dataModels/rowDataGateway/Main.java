package dataModels.rowDataGateway;

import dataModels.tableDataGateway.Product;
import dataModels.tableDataGateway.ProductTableGateway;

import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public class Main {
    public static void main(String[] args) {
        // Creăm o instanță a ProductRowGateway pentru un produs existent cu ID-ul 1
        ProductRowGateway productRowGateway = new ProductRowGateway(1);

        // Afișăm informații despre produsul curent
        System.out.println("Informații despre produsul curent:");
        System.out.println("ID: " + productRowGateway.getId());
        System.out.println("Nume: " + productRowGateway.getName());
        System.out.println("Preț: " + productRowGateway.getPrice());

        // Actualizăm numele produsului
        try {
            productRowGateway.setName("Updated Laptop");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișăm informații actualizate despre produsul curent
        System.out.println("Informații despre produsul curent după actualizare:");
        System.out.println("ID: " + productRowGateway.getId());
        System.out.println("Nume: " + productRowGateway.getName());
        System.out.println("Preț: " + productRowGateway.getPrice());

        // Adăugăm un nou produs
        ProductRowGateway newProductRowGateway = null;
        try {
            newProductRowGateway = new ProductRowGateway(6);
            newProductRowGateway.setName("New Product");
            newProductRowGateway.setPrice(99.99);
            newProductRowGateway.insert();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișăm toate produsele pentru a vedea adăugarea
        System.out.println("Toate produsele după adăugare:");
        displayAllProducts();

        // Ștergem un produs
        try {
            newProductRowGateway.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișăm din nou toate produsele pentru a vedea ștergerea
        System.out.println("Toate produsele după ștergere:");
        displayAllProducts();

        // Închidem conexiunea la baza de date
        productRowGateway.closeConnection();
    }

    private static void displayAllProducts() {
        ProductTableGateway productTableGateway = new ProductTableGateway();
        List<Product> allProducts = productTableGateway.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
        productTableGateway.closeConnection();
    }
}
