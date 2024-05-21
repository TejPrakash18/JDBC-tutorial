package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:postgresql://localhost:5432/TestDb";
        // Database credentials
        String user = "postgres";
        String password = "1234";
        String jdbcDriver = "org.postgresql.Driver";

        try {
            // Registering the PostgreSQL JDBC driver
            Class.forName(jdbcDriver);
            // Establishing the connection
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostGreSQL server successfully.");
            // Don't forget to close the connection when done
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}

