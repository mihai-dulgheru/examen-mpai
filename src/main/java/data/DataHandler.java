package data;

import java.io.IOException;

public interface DataHandler {
    void write(String data, String fileName) throws IOException;

    String read(String fileName) throws IOException, ClassNotFoundException;
}
