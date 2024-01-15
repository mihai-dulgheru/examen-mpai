package data;

import java.io.*;

public class BinaryFileHandler implements DataHandler {
    @Override
    public void write(String data, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
        }
    }

    @Override
    public String read(String fileName) throws IOException, ClassNotFoundException {
        StringBuilder content = new StringBuilder();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = inputStream.readObject();
            if (obj instanceof String) {
                content.append((String) obj);
            }
        }
        return content.toString();
    }
}
