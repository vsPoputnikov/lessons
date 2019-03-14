package homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem3_7 {
    public static void solve() {
//
        List<Integer> myList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Введите строку для обработки");
        StringBuilder sbStart = new StringBuilder(in.next());
        in = new Scanner(sbStart.toString()).useDelimiter("\\D+");
        String s;
        while (in.hasNext()) {
            s = in.next();
            myList.add(Integer.valueOf(s));
            System.out.println(s);
        }
        System.out.println(myList.toString());
    }

}
