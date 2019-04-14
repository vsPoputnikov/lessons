package homework1;

import java.util.Random;

public class Problem1_1 {
    public static void solve() {
        final Random random = new Random();
        int length, width, height; // Три измерения прямоугольного параллелограмма
        length = random.nextInt(10)+1;//длина
        width = random.nextInt(10)+1;//ширина
        height = random.nextInt(10)+1;//высота
        double s = (length*width + length*height + width*height)*2; // Площадь поверхности
        System.out.println("Задание 1.\n Площадь поверхности параллелепипеда с длиной "+length+" м," +
                "шириной "+width+" м, высотой "+height+" м,\n сгенерированными случайно в диапазоне 0..10" +
                " равна "+s+" м2");
        if ((width > height)) {
            System.out.println("Ширина больше высоты");
        } else {
            if ((height > width)) {
                System.out.println("Высота больше ширины");
            } else {
                System.out.println("Ширина равна высоте");
            }
        }
    }
}
