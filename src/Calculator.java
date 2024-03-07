import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calculator extends JFrame {

    StringBuilder input;
    JLabel screen;
    JPanel buttonsContainer = new JPanel(new GridLayout(5,4,0,0));

    //method to set settings of each number button and add it to the JPanel.
    void addButton(JButton buttonName,int value){
        buttonName.setFont(new Font("Consolas",Font.BOLD,50));
        buttonName.addActionListener(e-> {
            input.append(value);
            screen.setText(input.toString());
        });
        buttonsContainer.add(buttonName);
    }
    Calculator(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520,540);

        //StringBuilder to hold user input.
        input = new StringBuilder();
        double[] value = new double[1]; //used array so can be accessed in lambda expression.
        ArrayList<Double> inputs = new ArrayList<>(); //list of numbers input
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
        buttonsContainer.setBounds(0,100,500,400);
        buttonsContainer.setBackground(Color.blue);
        buttonsContainer.setFont(new Font("Consolas",Font.PLAIN,100));

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
        JButton bMULTIPLY = new JButton("×");
        JButton bDIVIDE = new JButton("÷");
        JButton bEQUALS = new JButton("=");
        JButton bCLEAR = new JButton("C");
        JButton bDEL = new JButton("DEL");

        //decimal point
        JButton bDECIMAL = new JButton(".");

        bADD.setFont(new Font("Consolas",Font.BOLD,50));
        bSUBTRACT.setFont(new Font("Consolas",Font.BOLD,50));
        bMULTIPLY.setFont(new Font("Consolas",Font.BOLD,50));
        bDIVIDE.setFont(new Font("Consolas",Font.BOLD,50));
        bCLEAR.setFont(new Font("Consolas",Font.BOLD,50));
        bEQUALS.setFont(new Font("Consolas",Font.BOLD,50));
        bDEL.setFont(new Font("Consolas",Font.BOLD,50));
        bDECIMAL.setFont(new Font("Consolas",Font.BOLD,50));

        bADD.setBackground(Color.orange);
        bSUBTRACT.setBackground(Color.orange);
        bMULTIPLY.setBackground(Color.orange);
        bDIVIDE.setBackground(Color.orange);
        bEQUALS.setBackground(Color.orange);
        bCLEAR.setBackground(Color.green);
        //Adding functionality to buttons


        bDECIMAL.addActionListener(e->{
            input.append(".");
            screen.setText(input.toString());
        });
        bDEL.addActionListener(e->{
            input.deleteCharAt(input.length()-1);
            screen.setText(input.toString());
        });

        bADD.addActionListener(e-> {
            //if statement so first list value defaults to current result if no number entered.
            if (input.length() != 0){
                value[0] = Double.parseDouble(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('+');
        });
        bSUBTRACT.addActionListener(e-> {
            if (input.length() != 0){
                value[0] = Double.parseDouble(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('-');
        });
        bMULTIPLY.addActionListener(e-> {
            if (input.length() != 0){
                value[0] = Double.parseDouble(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('*');
        });
        bDIVIDE.addActionListener(e-> {
            if (input.length() != 0){
                value[0] = Double.parseDouble(input.toString());
            }
            inputs.add(value[0]);
            input.setLength(0);
            operators.add('/');
        });
        bEQUALS.addActionListener(e-> {
            inputs.add(Double.parseDouble(input.toString()));
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
        buttonsContainer.add(bCLEAR);
        buttonsContainer.add(new JLabel());
        buttonsContainer.add(new JLabel());
        buttonsContainer.add(bDIVIDE);

        addButton(b7,7);
        addButton(b8,8);
        addButton(b9,9);
        buttonsContainer.add(bMULTIPLY);

        addButton(b4,4);
        addButton(b5,5);
        addButton(b6,6);
        buttonsContainer.add(bSUBTRACT);


        addButton(b1,1);
        addButton(b2,2);
        addButton(b3,3);
        buttonsContainer.add(bADD);

        addButton(b0,0);
        buttonsContainer.add(bDECIMAL);
        buttonsContainer.add(bDEL);
        buttonsContainer.add(bEQUALS);




        this.add(screenContainer);
        this.add(buttonsContainer);
        this.setLayout(null);
        this.setVisible(true);
    }
}
