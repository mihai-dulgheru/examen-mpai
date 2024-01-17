package dataModels.tableDataGateway.file;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ProductTableGateway productGateway = new ProductTableGateway();

            // Crearea și inserarea unui nou produs
            System.out.println("Inserăm un produs nou.");
            productGateway.insertProduct("Telefon", 500.0);

            // Citirea și afișarea tuturor produselor
            System.out.println("Produsele curente:");
            List<Product> products = productGateway.getAllProducts();
            products.forEach(System.out::println);

            // Presupunem că vrem să actualizăm primul produs
            if (!products.isEmpty()) {
                Product firstProduct = products.get(0);
                System.out.println("Actualizăm primul produs.");
                productGateway.updateProduct(firstProduct.getId(), "Telefon actualizat", 550.0);
            }

            // Afișăm produsele după actualizare
            System.out.println("Produsele după actualizare:");
            productGateway.getAllProducts().forEach(System.out::println);

            // Ștergerea unui produs
            if (!products.isEmpty()) {
                Product firstProduct = products.get(0);
                System.out.println("Ștergem primul produs.");
                productGateway.deleteProduct(firstProduct.getId());
            }

            // Afișăm produsele rămase
            System.out.println("Produsele rămase după ștergere:");
            productGateway.getAllProducts().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
