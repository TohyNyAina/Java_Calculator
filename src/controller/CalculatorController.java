package controller;

import java.util.Scanner;

import model.CalculatorModel;
import view.CalculatorView;
import operations.Exponential;
import operations.NaturalLogarithm;
import operations.SquareRoot;
import operations.Operation;


public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void processUserInput() {
        Operation operation;
        int choice = 0; // Obtenez le choix de l'opération de l'interface graphique

        switch (choice) {
            case 1:
                operation = new NaturalLogarithm();
                break;
            case 2:
                operation = new Exponential();
                break;
            case 3:
                operation = new SquareRoot();
                break;
            default:
                System.out.println("Invalid choice. Exiting the program.");
                return;
        }

        double number = view.getNumber();
        double result = operation.calculate(number);
        model.setResult(result);
        view.displayResult(model.getResult());
    }
}
