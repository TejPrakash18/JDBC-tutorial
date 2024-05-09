package Projects.Demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp {
    SwingApp(){
        JFrame f = new JFrame();

        JLabel heading = new JLabel("Print Data on console....");
        heading.setBounds(70, 20, 180, 30);
        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(20, 50, 80, 20);


        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(20, 80, 80, 20);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(20, 110, 80, 20);

        JTextField firstNameTF = new JTextField();
        firstNameTF.setBounds(120, 50, 100, 20);


        JTextField lastNameTF = new JTextField();
        lastNameTF.setBounds(120, 80, 100, 20);

        JTextField dobTF = new JTextField();
        dobTF.setBounds(120, 110, 100, 20);

        JButton sbmt = new JButton("Submit");
        sbmt.setBounds(20, 160, 100, 30);
        sbmt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = firstNameTF.getText();
                String lName = lastNameTF.getText();
                String dob = dobTF.getText();
                System.out.println(name);
                System.out.println(lName);
                System.out.println(dob);
            }
        });

        JButton reset = new JButton("Reset");
        reset.setBounds(140,160,100,30);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameTF.setText("");
                lastNameTF.setText("");
                dobTF.setText("");
            }
        });

        f.add(heading);
        f.add(firstName);
        f.add(lastName);
        f.add(dob);
        f.add(firstNameTF);
        f.add(lastNameTF);
        f.add(dobTF);
        f.add(sbmt);
        f.add(reset);

        f.setSize(500,400);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new SwingApp();
    }
}
