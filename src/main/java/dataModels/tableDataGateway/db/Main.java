package dataModels.tableDataGateway.db;

import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public class Main {
    public static void main(String[] args) {
        // Creăm o instanță a ProductTableGateway
        ProductTableGateway productTableGateway = new ProductTableGateway();

        // Adăugăm un produs
        try {
            productTableGateway.insertProduct("Laptop", 1200.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișăm toate produsele
        List<Product> allProducts = productTableGateway.getAllProducts();
        System.out.println("Toate produsele:");
        for (Product product : allProducts) {
            System.out.println(product);
        }

        // Obținem un produs după ID
        int productIdToFind = 1;
        Product foundProduct = productTableGateway.getProductById(productIdToFind);
        if (foundProduct != null) {
            System.out.println("Produsul cu ID-ul " + productIdToFind + " este: " + foundProduct);
        } else {
            System.out.println("Nu s-a găsit niciun produs cu ID-ul " + productIdToFind);
        }

        // Actualizăm un produs existent
        int productIdToUpdate = 1;
        try {
            productTableGateway.updateProduct(productIdToUpdate, "New Laptop", 1500.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișăm din nou toate produsele pentru a vedea actualizarea
        List<Product> updatedProducts = productTableGateway.getAllProducts();
        System.out.println("Toate produsele după actualizare:");
        for (Product product : updatedProducts) {
            System.out.println(product);
        }

        // Ștergem un produs
        int productIdToDelete = 2;
        try {
            productTableGateway.deleteProduct(productIdToDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Afișăm din nou toate produsele pentru a vedea ștergerea
        List<Product> remainingProducts = productTableGateway.getAllProducts();
        System.out.println("Toate produsele după ștergere:");
        for (Product product : remainingProducts) {
            System.out.println(product);
        }

        // Închidem conexiunea la baza de date
        productTableGateway.closeConnection();
    }
}
