package homework1;

import java.util.Random;

public class Problem1_6 {
    public static void res() {
        final Random random = new Random();
        int x, a,b;
        x = random.nextInt(900)+100;
        a = x/100;
        b=(x%100)/10;
        if (a>b){
            b=x%10;
        } else{
            a = b;
            b = x%10;
        }
        if (a<b){
            a = b;
        }
        System.out.printf("Задание 6.%nВ числе %d наибольшая цифра %d%n",x,a);
    }

}
