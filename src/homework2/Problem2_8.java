package homework2;

public class Problem2_8 {
    public static void res(){
        int count = 0;
        for(int i=1;i<50001;i++){
            int z = i;
            while (z>0){
                if (z%10==2){
                    count++;
                    break;
                }
                z/=10;
            }
        }
        System.out.println("Количество табличек на замену " + count);
    }
}
