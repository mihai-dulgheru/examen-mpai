package data;

public class DataHandlerFactory {
    public static DataHandler createDataHandler(String fileType) {
        if ("text".equalsIgnoreCase(fileType)) {
            return new TextFileHandler();
        } else if ("binary".equalsIgnoreCase(fileType)) {
            return new BinaryFileHandler();
        }
        throw new IllegalArgumentException("Unsupported file type");
    }
}
