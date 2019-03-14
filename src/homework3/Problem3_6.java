package homework3;

import java.util.Scanner;

public class Problem3_6 {
    public static void solve() {
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Введите строку для обработки");
        StringBuilder sbStart = new StringBuilder(in.next());

        for (int i = 0; i < sbStart.length(); i++) {
            while (sbStart.lastIndexOf(Character.toString(sbStart.charAt(i))) != i) {
                sbStart.deleteCharAt(sbStart.lastIndexOf(Character.toString(sbStart.charAt(i))));
            }
            if (sbStart.charAt(i) == ' ') {
                sbStart.deleteCharAt(i);
                i--;
            }

        }
        System.out.println(sbStart);

    }
}
