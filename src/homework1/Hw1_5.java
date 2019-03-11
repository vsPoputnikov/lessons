package homework1;

public class Hw1_5 {
    public static void res() {
        System.out.printf("Задание 5.%n");
        double a,b,c,d,x1,x2;
        a = 1;
        b = 2;
        c = -3;
        d = b*b - 4*a*c;
        if (d<0){
            System.out.printf("Уравнение не имеет корней %n");
        } else if (d>0){
            x1 = ((-b)+Math.sqrt(d))/(2*a);
            x2 = ((-b)-Math.sqrt(d))/(2*a);
            System.out.printf("Уравнение имеет 2 корня: %.2f и %.2f %n",x1,x2);
        } else {
            x1=-b/(2*a);
            System.out.printf("Уравнение имеет 1 корень: %.2f %n", x1);
        }
    }
}
