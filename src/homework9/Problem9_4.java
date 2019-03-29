package homework9;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem9_4 {
    public static void solve() {
        ArrayList<String> strings = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            strings.add(in.nextLine());
        }
        for (int i = 1; i < 10; i++) {
            if ((strings.get(i).length())<(strings.get(i-1).length())){
                System.out.println("string № "+ i);
                return;
            }
        }
        System.out.println("OK");
    }
}
