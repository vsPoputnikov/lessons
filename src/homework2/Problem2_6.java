package homework2;

public class Problem2_6 {
    public static void solve(){
        int count = 0;
        for(int i=1;i<1000000;i++){
            int a = i%10 + (i/10)%10 + (i/100)%10;
            int b = (i/1000)%10 + (i/10000)%10 + (i/100000)%10;
            if (a==b){
                count++;
            }
        }
        System.out.printf("Число счастливых билетов %d %n",count);
    }
}
