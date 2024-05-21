package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Register{
    public Register(){
        JFrame f=new JFrame("Registration form");

        JLabel heading=new JLabel("Print data on console....");
        heading.setBounds(70,20,180,40);

        JLabel firstName=new JLabel("First Name");
        firstName.setBounds(20,50,80,20);

        JLabel lastName = new JLabel("Last name");
        lastName.setBounds(20,75,80,30);

        JLabel dob=new JLabel("Date-of-Birth");
        dob.setBounds(20,105,80,30);

        JTextField firstNameTf=new JTextField();
        firstNameTf.setBounds(120,50,100,20);

        JTextField lastNameTf=new JTextField();
        lastNameTf.setBounds(120, 80, 100, 20);

        JTextField  dobtf=new JTextField();
        dobtf.setBounds(120, 110, 100, 20);

        JLabel email = new JLabel("E-mail");
        email.setBounds(20,140,100,20);

        JTextField emailTF=new JTextField();
        emailTF.setBounds(120,140,100,20);

        JButton sbmt = new JButton("Submit");
        sbmt.setBounds(20, 180, 100, 30);

        sbmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = firstNameTf.getText();
                String lName = lastNameTf.getText();
                String dob = dobtf.getText();
                String email=emailTF.getText();
                System.out.println(name);
                System.out.println(lName);
                System.out.println(dob);
                System.out.println(email);
            }
        });

        JButton reset = new JButton("Reset");
        reset.setBounds(140,180,100,30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameTf.setText("");
                lastNameTf.setText("");
                dobtf.setText("");
                emailTF.setText("");
            }
        });

        f.add(heading);
        f.add(firstName);
        f.add(lastName);
        f.add(dob);
        f.add(firstNameTf);
        f.add(lastNameTf);
        f.add(dobtf);
        f.add(sbmt);
        f.add(reset);
        f.add(email);
        f.add(emailTF);

        f.setSize(500,500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
}

public class LoginPage {
    public LoginPage(){
        JFrame f=new JFrame("Login page");
        JLabel heading=new JLabel("login");
        heading.setBounds(70,20,180,30);

        JLabel Name = new JLabel("UserName");
        Name.setBounds(20,50,80,20);

        JTextField nameTF=new JTextField();
        nameTF.setBounds(120,50,100,20);

        JLabel Pass =new JLabel("Password");
        Pass.setBounds(20,75,80,30);

        JTextField passTF=new JTextField();
        passTF.setBounds(120,80,100,20);

        JButton sbmt = new JButton("Login");
        sbmt.setBounds(20, 120, 100, 30);
        sbmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = passTF.getText();
                if (pass.equals("gungun")) {
                    new Register();
                    System.out.println("Welcome");
                }

                else System.out.println("Failed");
            }
        });


        JButton reset = new JButton("Reset");
        reset.setBounds(140,120,100,30);

        reset.addActionListener(e -> {
            nameTF.setText("");
            passTF.setText("");
        });


        f.add(heading);
        f.add(Name);
        f.add(nameTF);
        f.add(Pass);
        f.add(passTF);
        f.add(sbmt);
        f.add(reset);

        f.setSize(500,500);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new LoginPage();
    }
}
