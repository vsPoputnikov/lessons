package homework3;

import java.util.Arrays;

public class Problem3_1 {
    public static void solve() {
        int[] arrayEven = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayEven[i] = (i + 1) * 2;
            System.out.println(arrayEven[i] + " ");
        }
        for (int i = 0; i < 10; i++) {
            arrayEven[i] = (i + 1) * 2;
            System.out.print(arrayEven[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arrayEven));
    }
}
