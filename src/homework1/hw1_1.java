package homework1;

public class hw1_1 {
    public static void main(String[] args) {
        int length, width, height;
        length = 2;
        width = 3;
        height = 4;
        double s = (length*width + length*height + width*height)*2;
        System.out.printf("Площадь поверхности параллелепипеда равна %.0f м2 %n", s);

    }
}
