package homework5.Calc;

public class Multiplication implements Executable {
    private double a;
    private double b;
    Multiplication(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double execute() {
        return a*b;
    }
}
