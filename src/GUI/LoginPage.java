package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Register {
    public Register() {
        JFrame registerFrame = new JFrame("Home Page");

        JLabel heading = new JLabel("Print data on console...");
        heading.setBounds(70, 20, 180, 40);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(20, 50, 80, 20);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(20, 80, 80, 20);

        JLabel dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(20, 110, 80, 20);

        JTextField firstNameField = new JTextField();
        firstNameField.setBounds(120, 50, 100, 20);

        JTextField lastNameField = new JTextField();
        lastNameField.setBounds(120, 80, 100, 20);

        JTextField dobField = new JTextField();
        dobField.setBounds(120, 110, 100, 20);

        JLabel emailLabel = new JLabel("E-mail");
        emailLabel.setBounds(20, 140, 80, 20);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 140, 100, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 180, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String dob = dobField.getText();
                String email = emailField.getText();
                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(dob);
                System.out.println(email);
            }
        });

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(140, 180, 100, 30);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameField.setText("");
                lastNameField.setText("");
                dobField.setText("");
                emailField.setText("");
            }
        });

        registerFrame.add(heading);
        registerFrame.add(firstNameLabel);
        registerFrame.add(lastNameLabel);
        registerFrame.add(dobLabel);
        registerFrame.add(firstNameField);
        registerFrame.add(lastNameField);
        registerFrame.add(dobField);
        registerFrame.add(emailLabel);
        registerFrame.add(emailField);
        registerFrame.add(submitButton);
        registerFrame.add(resetButton);

        registerFrame.setSize(300, 300);
        registerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        registerFrame.setLayout(null);
        registerFrame.setVisible(true);
    }
}

public class LoginPage {
    public LoginPage() {
        JFrame loginFrame = new JFrame("Login Page");

        JLabel heading = new JLabel("Login");
        heading.setBounds(70, 20, 180, 30);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20, 50, 80, 20);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(120, 50, 100, 20);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 80, 80, 20);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(120, 80, 100, 20);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 120, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();
                if (password.equals("tej07")) {
                    new Register();
                    loginFrame.dispose();
                    System.out.println("Welcome");
                } else {
                    System.out.println("Failed");
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

        loginFrame.setSize(300, 300);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setLayout(null);
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
