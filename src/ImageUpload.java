import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageUpload {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/imageupload";
        String username = "postgres";
        String password = "1234";
        String imageName = "C:\\Users\\tej22\\Downloads/MindMapping.png"; // Path to your image file

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the PostgreSQL server successfully.");

            File imageFile = new File(imageName);
            try (FileInputStream fis = new FileInputStream(imageFile);
                 PreparedStatement ps = connection.prepareStatement("INSERT INTO images (name, data) VALUES (?, ?)")) {
                ps.setString(1, imageName);
                ps.setBinaryStream(2, fis, (int) imageFile.length());
                ps.executeUpdate();
                System.out.println("Image inserted successfully.");
            } catch (IOException e) {
                System.out.println("Failed to read image file.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}


// SQL cmd for create image table
//CREATE TABLE images (
//        id SERIAL PRIMARY KEY,
//        name VARCHAR(255),
//data BYTEA
//);

