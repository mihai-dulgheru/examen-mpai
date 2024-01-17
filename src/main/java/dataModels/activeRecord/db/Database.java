package dataModels.activeRecord.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {
    public static Connection connection;
    public static Statement statement;

    private Database() {
    }

    public static void connect() {
        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection("jdbc:sqlite:client_database.db");
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            statement = connection.createStatement();
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit() {
        try {
            System.out.println("Committing changes...");
            connection.commit();
            System.out.println("Changes committed successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback() {
        try {
            System.out.println("Rolling back changes...");
            connection.rollback();
            System.out.println("Changes rolled back successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void disconnect() {
        try {
            System.out.println("Disconnecting from database...");
            connection.close();
            System.out.println("Disconnected from database successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
