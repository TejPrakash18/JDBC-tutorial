package Projects;

//import GUI.ProfilePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginPage {
    public LoginPage() {
        JFrame loginFrame = new JFrame("Login Page");
        ImageIcon appIcon = new ImageIcon("../thenotchers.png");
        loginFrame.setIconImage(appIcon.getImage());

        JLabel heading = new JLabel("Login");
        heading.setBounds(70, 20, 180, 30);

        JLabel usernameLabel = new JLabel("E-mail");
        usernameLabel.setBounds(20, 50, 80, 20);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(120, 50, 100, 20);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 80, 80, 20);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 80, 100, 20);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 120, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
                    String query = "SELECT * FROM users WHERE email = ? AND password = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        System.out.println("Welcome");
                        new Welcome();
                        loginFrame.dispose();

                    } else {
                        System.out.println("Invalid credentials");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(140, 120, 100, 30);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        loginFrame.add(heading);
        loginFrame.add(usernameLabel);
        loginFrame.add(usernameField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(loginButton);
        loginFrame.add(resetButton);

        loginFrame.setSize(500, 400);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();
    }
}
