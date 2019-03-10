package homework1;

public class Hw1_4 {
    public static void main(String[] args) {
        double n,m, ans;
        n = 11.45;
        m = 8.5;
        ans = (Math.abs(10-n))<Math.abs(10-m)?n:m;
        System.out.printf("Определить близость чисел %.2f и %.2f к числу 10: %n" +
                "число %.2f ближе", n, m, ans);
    }
}
