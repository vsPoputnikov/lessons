package homework3;

import java.util.Scanner;

public class Problem3_7 {
    public static void solve() {
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Введите строку для обработки");
        StringBuilder sbStart = new StringBuilder(in.next());
        Scanner inString = new Scanner(sbStart.toString()).useDelimiter("\\D+");
        //System.out.println(inString);
        String s;
        while (inString.hasNext()) {
            s = inString.next();
            System.out.println(s);
        }
    }
}
