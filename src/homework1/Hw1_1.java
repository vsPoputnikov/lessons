package homework1;

public class Hw1_1 {
    public static void main(String[] args) {
        int length, width, height; // Три измерения прямоугольного параллелограмма
        length = 3;//длина
        width = 3;//ширина
        height = 4;//высота
        double s = (length*width + length*height + width*height)*2; // Площадь поверхности
        System.out.printf("Площадь поверхности параллелепипеда равна %.0f м2 %n", s);
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
