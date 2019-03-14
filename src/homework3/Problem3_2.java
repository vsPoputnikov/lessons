package homework3;

public class Problem3_2 {
    public static void solve() {
        int[] arrayOdd = new int[50];
        for (int i = 0; i < 50; i++) {
            arrayOdd[i] = (i * 2) + 1;
            System.out.print(arrayOdd[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < 50; i++) {
            System.out.print(arrayOdd[arrayOdd.length - 1 - i] + " ");
        }
    }
}
