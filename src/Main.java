import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Calculator myCalculator = new Calculator();
        myCalculator.setTitle("Java Calculator");

        Image calculatorImage = new ImageIcon("calculator.jpg").getImage();
        myCalculator.setIconImage(calculatorImage);
    }
}