import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import operations.NaturalLogarithm;
import operations.Exponential;
import operations.SquareRoot;


public class SwingCalculator {
    private JFrame frame;
    private JTextField displayField;

    public SwingCalculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setEditable(false);
        frame.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4));

        String[] buttonLabels = {
                "ln", "exp", "√", "AC",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+", //Ajout du AC
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String currentText = displayField.getText();
                    String buttonText = button.getText();

                    // Traiter les actions de l'utilisateur en fonction du texte du bouton
                    if (buttonText.equals("=")) {

                        try {
                            ScriptEngineManager manager = new ScriptEngineManager();
                            ScriptEngine engine = manager.getEngineByName("JavaScript");
                            Object result = engine.eval(currentText);
                            displayField.setText(result.toString());
                        } catch (ScriptException ex) {
                            displayField.setText("Error");
                        }
                    } else if (buttonText.equals("ln")) {
                        // Calculer le logarithme naturel
                        double value = Double.parseDouble(currentText);
                        NaturalLogarithm ln = new NaturalLogarithm();
                        double result = ln.calculate(value);
                        displayField.setText(String.valueOf(result));
                    } else if (buttonText.equals("exp")) {
                        // Calculer l'exponentielle
                        double value = Double.parseDouble(currentText);
                        Exponential exp = new Exponential();
                        double result = exp.calculate(value);
                        displayField.setText(String.valueOf(result));
                    } else if (buttonText.equals("√")) {
                        // Calculer la racine carrée
                        double value = Double.parseDouble(currentText);
                        SquareRoot sqrt = new SquareRoot();
                        double result = sqrt.calculate(value);
                        displayField.setText(String.valueOf(result));
                    } else if (buttonText.equals("AC")) {
                        // Réinitialise le champ de texte
                        displayField.setText("");
                    } else {
                        // Ajouter le texte du bouton au champ de texte
                        displayField.setText(currentText + buttonText);
                    }
                }
            });
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingCalculator();
            }
        });
    }
}
