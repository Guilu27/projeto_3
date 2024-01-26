package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory(Connection connection) {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = intConnection();
        } else if (connection.isClosed()) {
            connection = intConnection();
        }
        return connection;
    }

    private static Connection intConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:15432/projeto_3", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
