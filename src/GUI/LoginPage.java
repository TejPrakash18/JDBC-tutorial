package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    public static void main(String[] args) {
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
                if (pass.equals("gungun")) System.out.println("Welcome");
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
}
