package Homework2;

public class Hw2_5 {
    public static void res(){
        int f1=1;
        int f2=f1;
        int buff;
        System.out.printf("%d %d ", f1, f2);
        for(int i=1; i<10;i++){
            buff = f2;
            f2=f1+f2;
            f1=buff;
            System.out.print(f2+" ");
        }
        System.out.println();
    }
}
