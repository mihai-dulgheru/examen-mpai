package dataModels.dao.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("CallToPrintStackTrace")
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseManager.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT * FROM books")) {

            while (resultSet.next()) {
                int isbn = resultSet.getInt("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");

                books.add(new Book(isbn, title, author, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getByIsbn(int isbn) {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE isbn = ?")) {

            statement.setInt(1, isbn);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");

                return new Book(isbn, title, author, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Book book) {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("INSERT INTO books (isbn, title, author, price) VALUES (?, ?, ?, ?)")) {

            statement.setInt(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDouble(4, book.getPrice());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Book book) {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("UPDATE books SET title = ?, author = ?, price = ? WHERE isbn = ?")) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getIsbn());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Book book) {
        try (Connection connection = DatabaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE isbn = ?")) {

            statement.setInt(1, book.getIsbn());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
