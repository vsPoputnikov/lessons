package homework5.Calc;

public class Addition implements Executable {
    private double a;
    private double b;
    Addition(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double execute() {
        return a+b;
    }
}
