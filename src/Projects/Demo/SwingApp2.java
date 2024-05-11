package Projects.Demo;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SwingApp2 {
    private SwingApp2(){

        JFrame jFrame = new JFrame("Swing App");


//        String imageUrl = "logo.png";
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon(SwingApp2.class.getResource("../CRUD/logo.png")));
        image.setBounds(60, 70, 580, 690);




        JLabel name = new JLabel("Name");
        name.setBounds(50, 20, 70, 30);


        JTextField input = new JTextField(20);
        input.setBounds(130, 20, 160, 30);

        JButton btn  = new JButton("Click Me");
        btn.addActionListener(e -> {
            String name1 = input.getText();
            if("kon".equals(name1)){
                System.out.println("Hey I'm swing");
            }
        });
        btn.setBounds(30, 50, 80, 20);

        JTextArea message = new JTextArea(5, 20);
        message.setBounds(50, 70, 120, 50);

        JButton btn1 = new JButton("MouseListener");
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Mouse clicked");
            }
        });
        btn1.setBounds(170, 110, 170, 30);

        jFrame.add(image);
        jFrame.add(name);
        jFrame.add(input);
        jFrame.add(btn);
        jFrame.add(message);
        jFrame.add(btn1);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(700,650);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    public static void main(String[] args){
        new SwingApp2();
    }
}
