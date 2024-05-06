import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/TestDb";
        String username = "postgres";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Update data in the table
            int idToUpdate = 3; // The ID of the row to update
            String newName = "Akku"; // The new name value
            int newAge = 23; // The new age value

            String sql = "UPDATE users SET name = ?, age = ? WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newName);
                statement.setInt(2, newAge);
                statement.setInt(3, idToUpdate);

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Data updated successfully.");
                } else {
                    System.out.println("No rows updated.");
                }
            } catch (SQLException e) {
                System.out.println("Failed to update data.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
