package homework1;

import java.io.PrintStream;

public class Problem1_2 {
    public static void solve() {
        double s, length, width;
        s = 10; // Площадь в сотках
        length = 25; // Длина грядки
        width = 15; // Ширина грядки
        s *= 100;
        System.out.printf("Задание 2.%nОставшаяся площадь = %f м2%n", (s % (length * width)));

    }
}
