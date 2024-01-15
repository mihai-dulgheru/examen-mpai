package dataModels.dao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Adăugare cărți
        BookDaoImpl bookDao = new BookDaoImpl();

        Book book1 = new Book(1, "Java Programming", "John Doe", 39.99);
        Book book2 = new Book(2, "Database Fundamentals", "Jane Smith", 29.99);

        bookDao.add(book1);
        bookDao.add(book2);

        // Obținere toate cărțile și afișare
        List<Book> allBooks = bookDao.getAll();
        System.out.println("Toate cărțile:");
        for (Book book : allBooks) {
            System.out.println(book);
        }

        // Actualizare preț pentru prima carte
        book1.setPrice(49.99);
        bookDao.update(book1);

        // Obținere după ISBN și afișare
        Book retrievedBook = bookDao.getByIsbn(1);
        if (retrievedBook != null) {
            System.out.println("\nCartea cu ISBN 1 după actualizare:");
            System.out.println(retrievedBook);
        }

        // Ștergere a doua carte
        bookDao.delete(book2);

        // Obținere toate cărțile după ștergere și afișare
        List<Book> updatedBooks = bookDao.getAll();
        System.out.println("\nToate cărțile după ștergere:");
        for (Book book : updatedBooks) {
            System.out.println(book);
        }

        // Închidere conexiune la baza de date
        DatabaseManager.closeConnection();
    }
}
