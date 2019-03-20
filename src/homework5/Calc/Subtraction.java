package homework5.Calc;

public class Subtraction implements Executable {
    private double a;
    private double b;
    Subtraction(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double execute() {
        return a-b;
    }
}
