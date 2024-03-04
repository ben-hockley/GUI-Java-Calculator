import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calculator extends JFrame {

    StringBuilder input;
    JLabel screen;
    Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520,540);

        //StringBuilder to hold user input.
        input = new StringBuilder();
        int[] value = new int[1]; //used array so can be accessed in lambda expression.
        ArrayList<Integer> inputs = new ArrayList<>(); //list of numbers input
        ArrayList<Character> operators = new ArrayList<>(); //list of operators used.




        //GUI
        //Calculator screen
        JPanel screenContainer = new JPanel(new GridLayout(1,1,0,0));
        screenContainer.setBounds(0,0,500,100);
        screenContainer.setBackground(Color.gray);

        screen = new JLabel("SCREEN");
        screen.setBackground(Color.black);
        screen.setForeground(Color.white);
        screen.setFont(new Font("Consolas",Font.PLAIN,100));

        screenContainer.add(screen);

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

        //Adding functionality to buttons
        b1.addActionListener(e-> {
            input.append(1);
            screen.setText(input.toString());
        });
        b2.addActionListener(e-> {
            input.append(2);
            screen.setText(input.toString());
        });
        b3.addActionListener(e-> {
            input.append(3);
            screen.setText(input.toString());
        });
        b4.addActionListener(e-> {
            input.append(4);
            screen.setText(input.toString());
        });
        b5.addActionListener(e-> {
            input.append(5);
            screen.setText(input.toString());
        });
        b6.addActionListener(e-> {
            input.append(6);
            screen.setText(input.toString());
        });
        b7.addActionListener(e-> {
            input.append(7);
            screen.setText(input.toString());
        });
        b8.addActionListener(e-> {
            input.append(8);
            screen.setText(input.toString());
        });
        b9.addActionListener(e-> {
            input.append(9);
            screen.setText(input.toString());
        });
        b0.addActionListener(e-> {
            input.append(0);
            screen.setText(input.toString());
        });

        bADD.addActionListener(e-> {
            //if statement so first list value defaults to current result if no number entered.
            if (input.length() != 0){
                value[0] = Integer.parseInt(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('+');
        });
        bSUBTRACT.addActionListener(e-> {
            if (input.length() != 0){
                value[0] = Integer.parseInt(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('-');
        });
        bMULTIPLY.addActionListener(e-> {
            if (input.length() != 0){
                value[0] = Integer.parseInt(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('*');
        });
        bDIVIDE.addActionListener(e-> {
            if (input.length() != 0){
                value[0] = Integer.parseInt(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('/');
        });
        bEQUALS.addActionListener(e-> {
            inputs.add(Integer.parseInt(input.toString()));
            input.setLength(0);
            value[0] = inputs.get(0); //set value to first value entered.
            for (int i=0;i<operators.size();i++){
                if (operators.get(i) == '+'){
                    value[0] += inputs.get(i+1);
                } else if (operators.get(i) == '-') {
                    value[0] -= inputs.get(i+1);
                } else if (operators.get(i) == '*') {
                    value[0] *= inputs.get(i+1);
                } else if (operators.get(i) == '/') {
                    value[0] /= inputs.get(i+1);
                }
            }
            screen.setText(String.valueOf(value[0]));
            //clear arrayLists for new calculation
            inputs.clear();
            operators.clear();
        });
        bCLEAR.addActionListener(e-> {
            input.setLength(0); //clear stringBuilder
            value[0] = 0;
            inputs.clear(); //clear arrayLists.
            operators.clear();
            screen.setText(""); //clear screen
        });

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
