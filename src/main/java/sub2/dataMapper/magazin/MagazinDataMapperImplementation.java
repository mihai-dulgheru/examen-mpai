package sub2.dataMapper.magazin;

import sub2.dataMapper.DataMapperException;
import sub2.mvc.magazin.Magazin;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MagazinDataMapperImplementation implements MagazinDataMapper {
    private final String filePath = "magazine.txt";

    @Override
    public Magazin find(String denumireMagazin) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String denumire = parts[1].trim();
                if (denumire.equals(denumireMagazin)) {
                    List<Integer> orderIds = extractOrderIds(parts[2].trim());
                    return new Magazin(denumire, orderIds);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Magazin magazinToBeUpdated) throws DataMapperException {
        List<String> lines = new ArrayList<>();
        boolean storeFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String denumire = parts[1].trim();

                if (denumire.equals(magazinToBeUpdated.getDenumire())) {
                    lines.add(magazinToBeUpdated.getDenumire() + "," + formatOrderIds(magazinToBeUpdated.getListaComenzi()));
                    storeFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!storeFound) {
            throw new DataMapperException("Store [" + magazinToBeUpdated.getDenumire() + "] is not found");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Magazin magazinToBeInserted) throws DataMapperException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(magazinToBeInserted.getDenumire() + "," + formatOrderIds(magazinToBeInserted.getListaComenzi()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataMapperException("Error inserting store into file");
        }
    }

    @Override
    public void delete(Magazin magazinToBeDeleted) throws DataMapperException {
        List<String> lines = new ArrayList<>();
        boolean storeFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String denumire = parts[1].trim();

                if (denumire.equals(magazinToBeDeleted.getDenumire())) {
                    storeFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!storeFound) {
            throw new DataMapperException("Store [" + magazinToBeDeleted.getDenumire() + "] is not found");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Magazin> getMagazine() {
        List<Magazin> stores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String denumire = parts[1].trim();
                List<Integer> orderIds = extractOrderIds(parts[2].trim());
                stores.add(new Magazin(denumire, orderIds));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stores;
    }

    private String formatOrderIds(List<Integer> orderIds) {
        StringBuilder builder = new StringBuilder();
        for (Integer orderId : orderIds) {
            builder.append(orderId).append(",");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1); // Remove the trailing comma
        }
        return builder.toString();
    }

    private List<Integer> extractOrderIds(String orderIdsString) {
        List<Integer> orderIds = new ArrayList<>();
        String[] parts = orderIdsString.split(",");
        for (String part : parts) {
            orderIds.add(Integer.parseInt(part.trim()));
        }
        return orderIds;
    }
}
