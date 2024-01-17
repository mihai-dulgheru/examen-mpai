package sub2.dataMapper.comanda;

import sub2.dataMapper.DataMapperException;
import sub2.mvc.comanda.Comanda;
import sub2.mvc.comanda.state.AStare;
import sub2.mvc.comanda.state.StarePlasata;
import sub2.mvc.comanda.state.StarePlatita;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaDataMapperImplementation implements ComandaDataMapper {
    private final String filePath = "comenzi.txt";

    @Override
    public Comanda find(int comandaID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                if (id == comandaID) {
                    AStare stare = null;
                    Comanda comanda = new Comanda(id, parts[1].trim(), Integer.parseInt(parts[2].trim()));
                    String tipStare = parts[3].trim();
                    switch (tipStare) {
                        case "plasata":
                            stare = new StarePlasata(comanda);
                            break;
                        case "platita":
                            stare = new StarePlatita(comanda);
                            break;
                    }
                    comanda.setStareComanda(stare);
                    return comanda;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Comanda comandaToBeUpdated) throws DataMapperException {
        List<String> lines = new ArrayList<>();
        boolean comandaFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                if (id == comandaToBeUpdated.getId()) {
                    lines.add(comandaToBeUpdated.getId() + "," + comandaToBeUpdated.getDetalii() + "," + comandaToBeUpdated.getIdClient() + "," + comandaToBeUpdated.getStareComanda());
                    comandaFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!comandaFound) {
            throw new DataMapperException("comanda [" + comandaToBeUpdated.getId() + "] is not found");
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
    public void insert(Comanda comandaToBeInserted) throws DataMapperException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(comandaToBeInserted.getId() + "," + comandaToBeInserted.getDetalii() + "," + comandaToBeInserted.getIdClient() + "," + comandaToBeInserted.getStareComanda());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataMapperException("Error inserting comanda into file");
        }
    }

    @Override
    public void delete(Comanda comandaToBeDeleted) throws DataMapperException {
        List<String> lines = new ArrayList<>();
        boolean studentFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());

                if (id == comandaToBeDeleted.getId()) {
                    studentFound = true;
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!studentFound) {
            throw new DataMapperException("comanda [" + comandaToBeDeleted.getId() + "] is not found");
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

    public List<Comanda> getComenzi() {
        List<Comanda> comenzi = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                AStare stare = null;
                Comanda comanda = new Comanda(Integer.parseInt(parts[0].trim()), parts[1].trim(), Integer.parseInt(parts[2].trim()));
                String tipStare = parts[3].trim();
                switch (tipStare) {
                    case "plasata" -> stare = new StarePlasata(comanda);
                    case "platita" -> stare = new StarePlatita(comanda);
                }
                comanda.setStareComanda(stare);
                comenzi.add(comanda);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comenzi;
    }
}
