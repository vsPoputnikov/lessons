package homework1;

import java.util.Random;

public class Problem1_1 {
    public static void res() {
        final Random random = new Random();
        int length, width, height; // Три измерения прямоугольного параллелограмма
        length = random.nextInt(10)+1;//длина
        width = random.nextInt(10)+1;//ширина
        height = random.nextInt(10)+1;//высота
        double s = (length*width + length*height + width*height)*2; // Площадь поверхности
        System.out.printf("Задание 1.%nПлощадь поверхности параллелепипеда с длиной %d м," +
                "шириной %d м, высотой %d м,%nсгенерированными случайно в диапазоне 0..10" +
                " равна %.0f м2 %n", length, width, height, s);
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
