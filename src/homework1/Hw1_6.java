package homework1;

public class Hw1_6 {
    public static void main(String[] args) {
        int x, a,b;
        x = 851;
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
        System.out.printf("В числе %d наибольшая цифра %d%n",x,a);
    }

}
