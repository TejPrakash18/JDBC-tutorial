package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNumber {
    AddNumber(){

        JFrame  f=new JFrame("calculator");

        JLabel heading=new JLabel("calculating two numbers");
        heading.setBounds(70,20,180,40);

        JLabel firstNumber=new JLabel("First Number");
        firstNumber.setBounds(20,50,80,20);

        JTextField FirstTF=new JTextField();
        FirstTF.setBounds(120,50,100,20);

        JLabel secondNumber =new JLabel("Second number");
        secondNumber.setBounds(20,75,90,30);

        JTextField secondTF=new JTextField();
        secondTF.setBounds(120,80,100,20);

        JLabel result=new JLabel("Result");
        result.setBounds(240,65,80,30);

        JTextField resultTF=new JTextField();
        resultTF.setBounds(300,70,100,25);

        JButton add=new JButton("ADD");
        add.setBounds(20,120,100,30);


        add.addActionListener(e -> {
            double first = Double.parseDouble(FirstTF.getText());
            double second = Double.parseDouble(secondTF.getText());
            double result1 = first + second;
            resultTF.setText(String.valueOf(result1));
            System.out.println(result1);
        });

        JButton subtract=new JButton("SUBTRACT");
        subtract.setBounds(130,120,100,30);

        JButton mul=new JButton("MULTIPLY");
        mul.setBounds(20,160,100,30);

        JButton div =new JButton("DIVISION");
        div.setBounds(130,160,100,30);
        JButton reset = new JButton("Reset");
        reset.setBounds(80,200,100,30);


        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstTF.setText("");
                secondTF.setText("");
                resultTF.setText("");
            }
        });







        f.add(heading);
        f.add(firstNumber);
        f.add(FirstTF);
        f.add(secondNumber);
        f.add(secondTF);
        f.add(result);
        f.add(resultTF);
        f.add(add);
        f.add(reset);
        f.add(subtract);
        f.add(mul);
        f.add(div);


        f.setSize(500,500);
        f.setLayout(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new AddNumber();
    }
}