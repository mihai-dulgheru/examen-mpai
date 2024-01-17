package sub2.dataMapper.client;

import sub2.dataMapper.DataMapperException;
import sub2.mvc.client.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDataMapperImplementation implements ClientDataMapper {
    private final String filePath = "clients.txt";

    @Override
    public Client find(int clientId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                if (id == clientId) {
                    return new Client(id, parts[1].trim(), parts[2].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Client clientToBeUpdated) throws DataMapperException {
        List<String> lines = new ArrayList<>();
        boolean clientFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());

                if (id == clientToBeUpdated.getId()) {
                    lines.add(clientToBeUpdated.getId() + "," + clientToBeUpdated.getNume() + "," + clientToBeUpdated.getPrenume());
                    clientFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!clientFound) {
            throw new DataMapperException("client [" + clientToBeUpdated.getId() + "] is not found");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Client clientToBeInserted) throws DataMapperException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(clientToBeInserted.getId() + "," + clientToBeInserted.getNume() + "," + clientToBeInserted.getPrenume());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataMapperException("Error inserting client into file");
        }
    }

    @Override
    public void delete(Client clientToBeDeleted) throws DataMapperException {
        List<String> lines = new ArrayList<>();
        boolean studentFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());

                if (id == clientToBeDeleted.getId()) {
                    studentFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!studentFound) {
            throw new DataMapperException("client [" + clientToBeDeleted.getNume() + "] is not found");
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

    public List<Client> getClients() {
        List<Client> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                students.add(new Client(Integer.parseInt(parts[0].trim()), parts[1].trim(), parts[2].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
