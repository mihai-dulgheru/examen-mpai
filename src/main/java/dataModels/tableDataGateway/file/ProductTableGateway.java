package dataModels.tableDataGateway.file;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductTableGateway {

    public List<Product> getAllProducts() throws IOException {
        return FileHelper.readAllLines().stream().map(this::parseProduct).collect(Collectors.toList());
    }

    public Product getProductById(int productId) throws IOException {
        return getAllProducts().stream().filter(product -> product.getId() == productId).findFirst().orElse(null);
    }

    public void insertProduct(String name, double price) throws IOException {
        List<Product> products = getAllProducts();
        int newId = products.stream().mapToInt(Product::getId).max().orElse(0) + 1;
        Product newProduct = new Product(newId, name, price);
        List<String> lines = products.stream().map(this::formatProduct).collect(Collectors.toList());
        lines.add(formatProduct(newProduct));
        FileHelper.writeAllLines(lines);
    }

    public void updateProduct(int productId, String name, double price) throws IOException {
        List<Product> products = getAllProducts();
        List<String> lines = products.stream().map(product -> product.getId() == productId ? formatProduct(new Product(productId, name, price)) : formatProduct(product)).collect(Collectors.toList());
        FileHelper.writeAllLines(lines);
    }

    public void deleteProduct(int productId) throws IOException {
        List<Product> products = getAllProducts();
        products.removeIf(product -> product.getId() == productId);
        List<String> lines = products.stream().map(this::formatProduct).collect(Collectors.toList());
        FileHelper.writeAllLines(lines);
    }

    private Product parseProduct(String line) {
        String[] data = line.split(",");
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        return new Product(id, name, price);
    }

    private String formatProduct(Product product) {
        return product.getId() + "," + product.getName() + "," + product.getPrice();
    }
}
