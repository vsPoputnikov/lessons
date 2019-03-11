package Homework2;

import java.util.Scanner;

public class Hw2_4 {
    public static void res(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите натуральное число");
        int n = in.nextInt();
        for (int i = 2;i<n;i++){
            if (n%i==0){
                System.out.println("Число не простое");
                break;
            }
            if (i==n-1){
                System.out.println("Число простое");
            }
        }
    }
}
