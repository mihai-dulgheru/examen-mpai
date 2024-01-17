package dataModels.dao.db;

import java.util.List;

public interface BookDao {
    List<Book> getAll();

    Book getByIsbn(int isbn);

    boolean add(Book book);

    boolean update(Book book);

    boolean delete(Book book);
}
