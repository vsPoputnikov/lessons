package homework3;

import java.util.Random;

public class Problem3_3 {
    public static void solve() {
        final Random random = new Random();
        int[] arrayRandom = new int[15];
        int count = 0;
        for (int i = 0; i < arrayRandom.length; i++) {
            arrayRandom[i] = random.nextInt(11);
            System.out.print(arrayRandom[i] + " ");
            if (arrayRandom[i] % 2 == 0) {
                count++;
            }

        }
        System.out.println();
        System.out.println("Number of even elements " + count);
    }
}
