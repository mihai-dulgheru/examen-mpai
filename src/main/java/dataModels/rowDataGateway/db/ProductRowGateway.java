package dataModels.rowDataGateway.db;

import java.sql.*;

@SuppressWarnings("CallToPrintStackTrace")
public class ProductRowGateway {
    private static final String URL = "jdbc:sqlite:product_database.db";
    private Connection connection;
    private int id;
    private String name;
    private double price;

    public ProductRowGateway(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(URL);
            this.id = id;
            load();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void load() throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement("SELECT * FROM products WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name");
                price = resultSet.getDouble("price");
            }
        }
    }

    public Connection getConnection() throws SQLException {
        if (connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement("UPDATE products SET name = ? WHERE id = ?")) {
            this.name = name;
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement("UPDATE products SET price = ? WHERE id = ?")) {
            this.price = price;
            statement.setDouble(1, price);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    public void insert() throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement("INSERT INTO products (id, name, price) VALUES (?, ?, ?)")) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, price);
            statement.executeUpdate();
        }
    }

    public void update() throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement("UPDATE products SET name = ?, price = ? WHERE id = ?")) {
            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, id);
            statement.executeUpdate();
        }
    }

    public void delete() throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement("DELETE FROM products WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
