import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);

        //Calculator screen
        JPanel screenContainer = new JPanel(new GridLayout(1,1,0,0));
        screenContainer.setBounds(0,0,500,100);
        screenContainer.setBackground(Color.gray);

        //Calculator buttons
        JPanel buttonsContainer = new JPanel(new GridLayout(4,4,0,0));
        buttonsContainer.setBounds(0,100,500,400);
        buttonsContainer.setBackground(Color.blue);


        this.add(screenContainer);
        this.add(buttonsContainer);
        this.setLayout(null);
        this.setVisible(true);
    }
}
