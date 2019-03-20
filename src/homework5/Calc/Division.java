package homework5.Calc;

public class Division implements Executable {
    private double a;
    private double b;
    Division(double a, double b){
        this.a = a;
        this.b = b;
    }
    @Override
    public double execute() {
        return a/b;
    }
}
