package homework9;

import java.util.LinkedList;
import java.util.Scanner;

public class Problem9_3 {
    public static void solve() {
        LinkedList<String> strings = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            strings.addLast(in.nextLine());
        }
        System.out.println(strings);
        strings.remove(2);
        for (int i = 0; i < 4; i++) {
            System.out.println(strings.pollLast());
        }
    }
}
