package homework3;

import java.util.Scanner;

public class Problem3_5 {
    public static void solve() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходную строку");
        StringBuilder stringBuilder = new StringBuilder(in.next());
        System.out.println(stringBuilder.toString());

        System.out.println("Введите подстроку для замены");
        String replaceString = in.next();

        System.out.println("Введите строку для вставки");
        String insertString = in.next();

        int start = stringBuilder.indexOf(replaceString);
        stringBuilder.delete(start,start+replaceString.length());
        stringBuilder.insert(start, insertString );

        System.out.println(stringBuilder);
    }
}
