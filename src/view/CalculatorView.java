package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.CalculatorController;

public class CalculatorView {
    private CalculatorController controller;
    private JFrame frame;
    private JTextField numberField;
    private JTextField resultField;

    public void setController(CalculatorController controller) {
        this.controller = controller;
    }

    public void createAndShowGUI() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        numberField = new JTextField(10);
        inputPanel.add(numberField);

        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.processUserInput();
            }
        });
        buttonPanel.add(calculateButton);

        JPanel resultPanel = new JPanel();
        resultField = new JTextField(10);
        resultField.setEditable(false);
        resultPanel.add(resultField);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public double getNumber() {
        return Double.parseDouble(numberField.getText());
    }

    public void displayResult(double result) {
        resultField.setText(Double.toString(result));
    }
}
