package homework1;

import java.util.Random;

public class Hw1_4 {
    public static void res() {
        final Random random = new Random();
        double n,m, ans;
        n = random.nextInt(2000)/100d;
        m = random.nextInt(2000)/100d;
        ans = (Math.abs(10-n))<Math.abs(10-m)?n:m;
        System.out.printf("Задание 4.%nОпределить близость чисел %.2f и %.2f к числу 10: %n" +
                "число %.2f ближе%n", n, m, ans);
    }
}
