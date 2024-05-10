package Projects.Demo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SwingApp2 {
    private SwingApp2(){

        JFrame jFrame = new JFrame("Swing App");







        JLabel name = new JLabel("Name");
        name.setBounds(50, 20, 70, 30);


        JTextField input = new JTextField(20);
        input.setBounds(130, 20, 160, 30);

        JButton btn  = new JButton("Click Me");
        btn.addActionListener(e -> {
            String name1 = input.getText();
            if("kya".equals(name1)){
                System.out.println("Hey I'm swing");
            }


        });
        btn.setBounds(30, 50, 80, 20);

        JTextArea message = new JTextArea(5, 20);
        message.setBounds(50, 70, 120, 50);


        jFrame.add(name);
        jFrame.add(input);
        jFrame.add(btn);
        jFrame.add(message);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(500,600);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    public static void main(String[] args){
        new SwingApp2();
    }
}
