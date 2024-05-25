package Projects;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Register {
    public Register() {
        JFrame registerFrame = new JFrame("Register Page");
        ImageIcon appIcon = new ImageIcon("thenotchers.png");
        registerFrame.setIconImage(appIcon.getImage());

        JLabel heading = new JLabel("Register");
        heading.setBounds(70, 20, 180, 40);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(20, 50, 80, 20);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(20, 80, 80, 20);


        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(120, 50, 100, 20);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(120, 80, 100, 20);

        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(20, 110, 80, 20);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 110, 100, 20);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 140, 80, 20);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(120, 140, 100, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 210, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
                    String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setString(3, email);
                    preparedStatement.setString(4, password);
                    preparedStatement.executeUpdate();
                    System.out.println("User registered successfully");
                    new LoginPage();
                    registerFrame.dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton resetButton = new JButton("Login");
        resetButton.setBounds(140, 210, 100, 30);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new LoginPage();
            }
        });

        registerFrame.add(heading);
        registerFrame.add(firstNameLabel);
        registerFrame.add(lastNameLabel);
        registerFrame.add(firstNameField);
        registerFrame.add(lastNameField);
        registerFrame.add(emailLabel);
        registerFrame.add(emailField);
        registerFrame.add(passwordLabel);
        registerFrame.add(passwordField);
        registerFrame.add(submitButton);
        registerFrame.add(resetButton);

        registerFrame.setSize(500, 400);
        registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registerFrame.setLayout(null);
        registerFrame.setVisible(true);
    }
}
