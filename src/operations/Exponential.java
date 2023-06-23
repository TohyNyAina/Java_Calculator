package operations;

public class Exponential extends Operation {
    @Override
    public double calculate(double x) {
        return Math.exp(x);
    }
}
