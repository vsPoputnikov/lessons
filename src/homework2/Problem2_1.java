package homework2;

import java.util.Scanner;

public class Problem2_1 {
    public static void res() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа для упорядочивания");
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), buff;
        for (int i=0;i<2;i++){
            if (a>b) {
                buff = b;
                b = a;
                a = buff;
            }
            if(b>c){
                buff = c;
                c = b;
                b = buff;
            }
        }
        System.out.printf("%d %d %d %n",a,b,c);
    }

}
