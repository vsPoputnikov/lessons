package Lesson2;

import java.util.Locale;
import java.util.Scanner;

public class Lesson2 {
    // Конструкции ветвления
    public static void main(String[] args) {
        System.out.println("Вывод информации");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите код");
        int code = in.nextInt();
        in.useLocale(Locale.US);// Для разделения дробной части . а не ,
        if (code == 123) {
            System.out.println("Вы вошли как админисстратор");
        } else if (code == 345) {
            System.out.println("Вы вошли как пользователь");
        } else {
            System.out.println("Вы не вошли");
        }

        int a = 5, b = 7;
        if (a == 5) {
            System.out.println("Совпадение а=5");
        } else if (b == 7) {
            System.out.println("Совпадение b=7");
        }

        // Конструкция switch
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите номер");
        int num = in2.nextInt();

        String string = new String();
        switch (num) {
            case 333333:
                string = "Jack Pot";
                break;
            case 333334:
            case 333335:
                string = "mid pot";
                break;
            case 333345:
                string = "small pot";
                break;
            default:
                string = "go home, peasant";
        }
        System.out.println(string);

        // Циклы
        int count = 5;
        while (count > 0) {
            System.out.println("сообщение " + count);
            count--;
        }
        do {
            System.out.println("первая итерация");
        } while (false);

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue; // Переход к следующей итерации
            System.out.println("i = " + i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Внешний цикл " + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("j = " + j);
                if (j == 5) break;
            }
            System.out.println();
        }
        // Метки

        outer:  for (int i = 0; i < 3; i++) {
            System.out.println("Внешний цикл dsds");
            for (int j = 0; j < 10; j++) {
                System.out.println("j = " + j);
                if (j == 5) break outer;
            }
        }

    }}
