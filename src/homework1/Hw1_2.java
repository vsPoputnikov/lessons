package homework1;

import java.io.PrintStream;

public class Hw1_2 {
    public static void main(String[] args) {
        double s, length, width;
        s = 10; // Площадь в сотках
        length = 25; // Длина грядки
        width = 15; // Ширина грядки
        s *= 100;
        System.out.printf("Оставшаяся площадь = %f м2", (s % (length * width)));

    }
}
