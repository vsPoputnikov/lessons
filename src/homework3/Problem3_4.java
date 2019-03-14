package homework3;

import java.util.Random;
import java.util.Scanner;

public class Problem3_4 {
    public static void solve() {
        Random random = new Random();
        Scanner in = new Scanner(System.in);
        int arrLength;
        int sum1 = 0;  // Переменные для подсчёта сумм половин массива
        int sum2 = 0;
        // Чтение длины массива
        do {
            System.out.println("введите чётное положительное число");
            arrLength = in.nextInt();
        } while ((arrLength % 2 != 0) ||(arrLength < 0));
        // Создание и инициализация
        int[] array = new int[arrLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (random.nextInt(11) - 5);
            System.out.print(array[i] + " ");
        }
        // подсчёт сумм и вывод результата:
        for (int i = 0; i < array.length/2; i++) {
            sum1 += Math.abs(array[i]);
            sum2 += Math.abs(array[i + array.length/2]);
        }
        System.out.println();
        System.out.println(sum1 + " " + sum2);
        if (sum1>sum2){
            System.out.println("сумма модулей первой половины больше второй");
        } else if (sum2>sum1){
            System.out.println("сумма модулей второй половины больше первой");
        } else
            System.out.println("суммы равны");

    }
}
