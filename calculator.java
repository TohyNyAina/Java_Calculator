public class calculator implements VarCalculator{
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return num1 / num2;
    }
    public double squareRoot(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double logarithm(double num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Cannot calculate logarithm of a non-positive number");
        }
        return Math.log10(num);
    }

    public double factorial(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number");
        }
        if (num == 0) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}





