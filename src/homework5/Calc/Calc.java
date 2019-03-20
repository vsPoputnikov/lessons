package homework5.Calc;


import java.util.Scanner;

public class Calc {
    public static void solve() {
        Scanner in = new Scanner(System.in);
        double a, b;
        String op;

        a = in.nextDouble();
        while (true) {
            op = in.next();
            b = in.nextDouble();
            opi:
            switch (op) {
                case "+":
                    a = new Addition(a, b).execute();
                    System.out.println(a);
                    break opi;
                case "-":
                    a = new Subtraction(a, b).execute();
                    System.out.println(a);
                    break opi;
                case "*":
                    a = new Multiplication(a, b).execute();
                    System.out.println(a);
                    break opi;
                case "/":
                    a = new Division(a, b).execute();
                    System.out.println(a);
                    break opi;
            }

        }
    }
}
