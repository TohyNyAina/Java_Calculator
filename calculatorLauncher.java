import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculatorLauncher extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton clearButton, zeroButton, squareRootButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, eqButton, minusButton, productButton, addButton, divideButton, commaButton, lnButton, expoButton, delButton;
    private VarCalculator calc;
    private String operator = "";
    private double a = 0;
    private double b = 0;
    private double result = 0;

    public calculatorLauncher() {
        //=======================================Section Instance=======================================================
        calc = new calculator();

        //=======================================Section Basic==========================================================
        Container c = getContentPane();
        setTitle("Calculatrice");
        c.setLayout(null);
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //=======================================Section Inputs=========================================================
        inputField = new JTextField();
        inputField.setEditable(false);
        inputField.setBounds(20, 5, 240, 40);
        c.add(inputField);


        delButton = new JButton("DEL");
        delButton.setBounds(200, 60, 60, 40);
        delButton.addActionListener(this);
        c.add(delButton);

        lnButton = new JButton("ln");
        lnButton.setBounds(20, 100, 60, 40);
        lnButton.addActionListener(this);
        c.add(lnButton);

        expoButton = new JButton("e");
        expoButton.setBounds(80, 100, 60, 40);
        expoButton.addActionListener(this);
        c.add(expoButton);

        squareRootButton = new JButton("√");
        squareRootButton.setBounds(140, 100, 60, 40);
        squareRootButton.addActionListener(this);
        c.add(squareRootButton);
        
        clearButton = new JButton("AC");
        clearButton.setBounds(200, 100, 60, 40);
        clearButton.addActionListener(this);
        c.add(clearButton);

        oneButton = new JButton("1");
        oneButton.setBounds(20, 140, 60, 40);
        oneButton.addActionListener(this);
        c.add(oneButton);

        twoButton = new JButton("2");
        twoButton.setBounds(80, 140, 60, 40);
        twoButton.addActionListener(this);
        c.add(twoButton);

        threeButton = new JButton("3");
        threeButton.setBounds(140, 140, 60, 40);
        threeButton.addActionListener(this);
        c.add(threeButton);

        addButton = new JButton("+");
        addButton.setBounds(200, 140, 60, 40);
        addButton.addActionListener(this);
        c.add(addButton);

        fourButton = new JButton("4");
        fourButton.setBounds(20, 180, 60, 40);
        fourButton.addActionListener(this);
        c.add(fourButton);

        fiveButton = new JButton("5");
        fiveButton.setBounds(80, 180, 60, 40);
        fiveButton.addActionListener(this);
        c.add(fiveButton);

        sixButton = new JButton("6");
        sixButton.setBounds(140, 180, 60, 40);
        sixButton.addActionListener(this);
        c.add(sixButton);

        minusButton = new JButton("-");
        minusButton.setBounds(200, 180, 60, 40);
        minusButton.addActionListener(this);
        c.add(minusButton);

        sevenButton = new JButton("7");
        sevenButton.setBounds(20, 220, 60, 40);
        sevenButton.addActionListener(this);
        c.add(sevenButton);

        eightButton = new JButton("8");
        eightButton.setBounds(80, 220, 60, 40);
        eightButton.addActionListener(this);
        c.add(eightButton);

        nineButton = new JButton("9");
        nineButton.setBounds(140, 220, 60, 40);
        nineButton.addActionListener(this);
        c.add(nineButton);

        divideButton = new JButton("/");
        divideButton.setBounds(200, 220, 60, 40);
        divideButton.addActionListener(this);
        c.add(divideButton);

        commaButton = new JButton(".");
        commaButton.setBounds(20, 260, 60, 40);
        commaButton.addActionListener(this);
        c.add(commaButton);

        zeroButton = new JButton("0");
        zeroButton.setBounds(80, 260, 60, 40);
        zeroButton.addActionListener(this);
        c.add(zeroButton);

        eqButton = new JButton("=");
        eqButton.setBounds(140, 260, 60, 40);
        eqButton.addActionListener(this);
        c.add(eqButton);

        productButton = new JButton("*");
        productButton.setBounds(200, 260, 60, 40);
        productButton.addActionListener(this);
        c.add(productButton);


        setVisible(true);
    }

    private void calculateResult() {
        if (!operator.equals("")) {
            b = Double.parseDouble(inputField.getText());
            switch (operator) {
                case "+":
                    result = calc.add(a, b);
                    break;
                case "-":
                    result = calc.subtract(a, b);
                    break;
                case "*":
                    result = calc.multiply(a, b);
                    break;
                case "/":
                    result = calc.divide(a, b);
                    break;
                default:
                    break;
            }
            inputField.setText(String.valueOf(result));
            a = result;
            b = 0;
            result = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String clicked = event.getActionCommand();
        switch (clicked) {
            case "+":
                operator = "+";
                a = Double.parseDouble(inputField.getText());
                inputField.setText("");
                break;
            case "-":
                operator = "-";
                a = Double.parseDouble(inputField.getText());
                inputField.setText("");
                break;
            case "*":
                operator = "*";
                a = Double.parseDouble(inputField.getText());
                inputField.setText("");
                break;
            case "/":
                operator = "/";
                a = Double.parseDouble(inputField.getText());
                inputField.setText("");
                break;
            case "1":
                inputField.setText(inputField.getText() + "1");
                break;
            case "2":
                inputField.setText(inputField.getText() + "2");
                break;
            case "3":
                inputField.setText(inputField.getText() + "3");
                break;
            case "4":
                inputField.setText(inputField.getText() + "4");
                break;
            case "5":
                inputField.setText(inputField.getText() + "5");
                break;
            case "6":
                inputField.setText(inputField.getText() + "6");
                break;
            case "7":
                inputField.setText(inputField.getText() + "7");
                break;
            case "8":
                inputField.setText(inputField.getText() + "8");
                break;
            case "9":
                inputField.setText(inputField.getText() + "9");
                break;
            case "0":
                inputField.setText(inputField.getText() + "0");
                break;
            case ".":
                inputField.setText(inputField.getText() + ".");
                break;
            case "=":
                calculateResult();
                break;
            case "AC":
                inputField.setText("");
                a = 0;
                b = 0;
                result = 0;
                operator = "";
                break;
            case "ln":
                double num = Double.parseDouble(inputField.getText());
                result = calc.logarithm(num);
                inputField.setText(String.valueOf(result));
                break;
            case "e":
                double base = Double.parseDouble(inputField.getText());
                result = calc.power(Math.E, base);
                inputField.setText(String.valueOf(result));
                break;
            case "√":
                double sqrtNum = Double.parseDouble(inputField.getText());
                result = calc.squareRoot(sqrtNum);
                inputField.setText(String.valueOf(result));
                break;
            case "DEL":
                String currentText = inputField.getText();
                if (!currentText.isEmpty()) {
                    inputField.setText(currentText.substring(0, currentText.length() - 1));
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new calculatorLauncher();
    }
}
