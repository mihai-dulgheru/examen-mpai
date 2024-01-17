package dataModels.dao.file;

public class Main {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();

        // Crearea și adăugarea unei cărți noi
        Book newBook = new Book(123456, "Effective Java", "Joshua Bloch", 40.00);
        boolean isAdded = bookDao.add(newBook);
        System.out.println("Cartea a fost adăugată: " + isAdded);

        // Obținerea și afișarea unei cărți după ISBN
        Book foundBook = bookDao.getByIsbn(123456);
        if (foundBook != null) {
            System.out.println("Cartea găsită: " + foundBook);
        } else {
            System.out.println("Cartea nu a fost găsită.");
        }

        // Actualizarea unei cărți
        if (foundBook != null) {
            foundBook.setPrice(45.00); // Modificăm prețul cărții
            boolean isUpdated = bookDao.update(foundBook);
            System.out.println("Cartea a fost actualizată: " + isUpdated);
        }

        // Ștergerea unei cărți
        boolean isDeleted = bookDao.delete(newBook);
        System.out.println("Cartea a fost ștearsă: " + isDeleted);

        // Afișarea tuturor cărților
        System.out.println("Toate cărțile disponibile:");
        for (Book book : bookDao.getAll()) {
            System.out.println(book);
        }
    }
}
