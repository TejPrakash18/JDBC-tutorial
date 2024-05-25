package Projects;

import javax.swing.*;
import java.awt.*;

public class Welcome {
    public Welcome(){
        JFrame welcomePage = new JFrame("Welcome");
        JLabel welcome = new JLabel("Welcome");
        welcome.setBounds(120, 120, 250, 40);
        welcome.setFont(new Font("Arial",Font.BOLD ,26 ));
        welcome.setForeground(Color.green);

        welcomePage.add(welcome);

        welcomePage.setLayout(null);
        welcomePage.setSize(500, 400);
        welcomePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        welcomePage.setVisible(true);
    }
}
