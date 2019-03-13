package homework2;

public class Problem2_9 {
    public static void solve(){
        int count = 0;
        for(int i=1;i<100000;i++){
            int z = i;
            while (z>0){
                if ((z%10==4)||((z%10==3)&&((z/10)%10==1))){
                    count++;
                    break;
                }
                z/=10;
            }
        }
        System.out.println("Количество техники " + count);
    }
}
