package dataModels.rowDataGateway.file;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRowGateway {
    private final int id;
    private String name;
    private double price;

    public ProductRowGateway(int id) {
        this.id = id;
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() throws IOException {
        List<String> lines = FileHelper.readAllLines();
        for (String line : lines) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) == id) {
                name = data[1];
                price = Double.parseDouble(data[2]);
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IOException {
        this.name = name;
        save();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IOException {
        this.price = price;
        save();
    }

    public void insert() throws IOException {
        String newLine = id + "," + name + "," + price;
        List<String> lines = FileHelper.readAllLines();
        lines.add(newLine);
        FileHelper.writeAllLines(lines);
    }

    public void update() throws IOException {
        List<String> lines = FileHelper.readAllLines();
        List<String> updatedLines = lines.stream().map(line -> {
            String[] data = line.split(",");
            if (Integer.parseInt(data[0]) == id) {
                return id + "," + name + "," + price;
            }
            return line;
        }).collect(Collectors.toList());

        FileHelper.writeAllLines(updatedLines);
    }

    public void delete() throws IOException {
        List<String> lines = FileHelper.readAllLines();
        lines = lines.stream().filter(line -> Integer.parseInt(line.split(",")[0]) != id).collect(Collectors.toList());

        FileHelper.writeAllLines(lines);
    }

    private void save() throws IOException {
        update(); // Reusing the update logic for saving
    }
}
