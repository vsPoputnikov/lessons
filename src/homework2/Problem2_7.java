package homework2;

public class Problem2_7 {
    public static void res(){
        int count = 0;
        for(int i= 0; i<24; i++){
            for(int j = 0; j<60; j++ ){
                if (((i % 10) == (j / 10)) && ((i / 10) == (j % 10))) {
                    count++;
                }
            }
        }
        System.out.println("Количество совпадений " + count);
    }
}
