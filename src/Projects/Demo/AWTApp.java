package Projects.Demo;

import javax.swing.*;
import java.awt.*;

public class AWTApp {
    public static void main(String[] args) {
        Frame frame = new Frame("Awt window");

        Label name  = new Label("Name");
        name.setBounds(20, 30, 80, 30);
        frame.add(name);

        TextField input = new TextField(20);
        input.setBounds(170, 30, 120, 40);
        frame.add(input);


        frame.setSize(500,400);
        frame.setVisible(true);
    }
}
