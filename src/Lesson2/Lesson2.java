package Lesson2;

import java.util.Scanner;

public class Lesson2 {
    // Конструкции ветвления
    public static void main(String[] args) {
        System.out.println("Вывод информации");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите код");
        int code = in.nextInt();

        if (code == 123){
            System.out.println("Вы вошли как админисстратор");
        } else {
            System.out.println("Вы не вошли");
        }
    }
}
