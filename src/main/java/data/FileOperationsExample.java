package data;

import java.io.IOException;

@SuppressWarnings("CallToPrintStackTrace")
public class FileOperationsExample {
    public static void main(String[] args) {
        // Exemplu de utilizare pentru operații cu fișiere text
        DataHandler textFileHandler = DataHandlerFactory.createDataHandler("text");
        String textData = "Hello, this is text file content.";
        String textFileName = "textFile.txt";

        try {
            // Scriere în fișier text
            textFileHandler.write(textData, textFileName);

            // Citire din fișier text
            String readTextData = textFileHandler.read(textFileName);
            System.out.println("Text file content: \n" + readTextData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Exemplu de utilizare pentru operații cu fișiere binare
        DataHandler binaryFileHandler = DataHandlerFactory.createDataHandler("binary");
        String binaryData = "Hello, this is binary file content.";
        String binaryFileName = "binaryFile.dat";

        try {
            // Scriere în fișier binar
            binaryFileHandler.write(binaryData, binaryFileName);

            // Citire din fișier binar
            String readBinaryData = binaryFileHandler.read(binaryFileName);
            System.out.println("Binary file content: \n" + readBinaryData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
