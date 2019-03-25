package lesson6.object.staticFinal;

public class CalcUtils {


    public static double summ(int a, int b){
        return a+b;
    }
    static final double PI = 3.14;

    static {

    }
    // final методы нельзя переопределить в дочерних
    public  final void someVoid(){}
}
