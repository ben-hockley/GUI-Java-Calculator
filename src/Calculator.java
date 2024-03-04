import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520,540);

        //Calculator screen
        JPanel screenContainer = new JPanel(new GridLayout(1,1,0,0));
        screenContainer.setBounds(0,0,500,100);
        screenContainer.setBackground(Color.gray);

        //Calculator buttons
        JPanel buttonsContainer = new JPanel(new GridLayout(4,4,0,0));
        buttonsContainer.setBounds(0,100,500,400);
        buttonsContainer.setBackground(Color.blue);

        //numbers
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");

        //operations
        JButton bADD = new JButton("+");
        JButton bSUBTRACT = new JButton("-");
        JButton bMULTIPLY = new JButton("X");
        JButton bDIVIDE = new JButton("÷");
        JButton bEQUALS = new JButton("=");
        JButton bCLEAR = new JButton("C");

        //add buttons to 4x4 Grid Layout
        buttonsContainer.add(b7);
        buttonsContainer.add(b8);
        buttonsContainer.add(b9);
        buttonsContainer.add(bADD);

        buttonsContainer.add(b4);
        buttonsContainer.add(b5);
        buttonsContainer.add(b6);
        buttonsContainer.add(bSUBTRACT);

        buttonsContainer.add(b1);
        buttonsContainer.add(b2);
        buttonsContainer.add(b3);
        buttonsContainer.add(bMULTIPLY);

        buttonsContainer.add(b0);
        buttonsContainer.add(bCLEAR);
        buttonsContainer.add(bDIVIDE);
        buttonsContainer.add(bEQUALS);



        this.add(screenContainer);
        this.add(buttonsContainer);
        this.setLayout(null);
        this.setVisible(true);
    }
}
