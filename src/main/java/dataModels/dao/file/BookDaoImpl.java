package dataModels.dao.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getAll() {
        try {
            return FileHelper.readAllLines().stream().map(this::parseBook).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Book getByIsbn(int isbn) {
        try {
            return FileHelper.readAllLines().stream().map(this::parseBook).filter(book -> book.getIsbn() == isbn).findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(Book book) {
        String bookData = book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPrice();
        try {
            List<String> lines = FileHelper.readAllLines();
            lines.add(bookData);
            FileHelper.writeAllLines(lines);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Book book) {
        try {
            List<String> lines = FileHelper.readAllLines();
            List<String> updatedLines = lines.stream().map(line -> {
                Book existingBook = parseBook(line);
                if (existingBook.getIsbn() == book.getIsbn()) {
                    return book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPrice();
                }
                return line;
            }).collect(Collectors.toList());

            FileHelper.writeAllLines(updatedLines);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Book book) {
        try {
            List<String> lines = FileHelper.readAllLines();
            lines = lines.stream().filter(line -> parseBook(line).getIsbn() != book.getIsbn()).collect(Collectors.toList());

            FileHelper.writeAllLines(lines);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Book parseBook(String line) {
        String[] data = line.split(",");
        int isbn = Integer.parseInt(data[0]);
        String title = data[1];
        String author = data[2];
        double price = Double.parseDouble(data[3]);
        return new Book(isbn, title, author, price);
    }
}
