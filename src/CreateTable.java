import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TestDb";
        String username = "postgres";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            String sql = "CREATE TABLE users " +
                    "(id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(255), " +
                    "age INT)";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
                System.out.println("Table created successfully.");
            } catch (SQLException e) {
                System.out.println("Failed to create table.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
