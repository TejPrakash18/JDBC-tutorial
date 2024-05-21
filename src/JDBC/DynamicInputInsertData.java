package JDBC;

import java.sql.*;
import java.util.Scanner;

public class DynamicInputInsertData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TestDb";
        String username = "postgres";
        String password = "1234";
        String tableName = "users";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Check if the table already exists
            if (!tableExists(connection, tableName)) {
                // Table does not exist, create it
                createTable(connection, tableName);
            } else {
                System.out.println("Table " + tableName + " already exists.");
            }

            // Insert data into the table
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            insertData(connection, tableName, name, age);
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    private static boolean tableExists(Connection connection, String tableName) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT to_regclass('" + tableName + "')")) {
            if (resultSet.next()) {
                return resultSet.getString(1) != null;
            }
        }
        return false;
    }

    private static void createTable(Connection connection, String tableName) throws SQLException {
        String sql = "CREATE TABLE " + tableName +
                " (id SERIAL PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "age INT)";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create table.");
            e.printStackTrace();
        }
    }

    private static void insertData(Connection connection, String tableName, String name, int age) throws SQLException {
        String sql = "INSERT INTO " + tableName + " (name, age) VALUES ('" + name + "', " + age + ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Failed to insert data.");
            e.printStackTrace();
        }
    }
}
