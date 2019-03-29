package homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem9_1 {
    public static void solve(){
        Scanner in = new Scanner(System.in);
        ArrayList<String> messages = new ArrayList<>(5);
        ArrayList<String> shortMessages  = new ArrayList<>();
        shortMessages.add("no messages");
        String S;
        int minLength = 0;
        int count = 0;
        do {
            System.out.println("Enter string or command:");
            S = in.nextLine();
            if (S.length()==0){
                continue;
            } else if (S.equals("short string")){
                System.out.println("shortest string: "+shortMessages);
                break;
            }
            else if((S.length()<minLength)|(count == 0)){
                minLength = S.length();
                shortMessages.clear();
                shortMessages.add(S);
            } else if(count>4){
                System.out.println("enough messages.");
                continue;
            }else if(S.length()==minLength){
                shortMessages.add(S);
            }

            count++;
        } while(true);
    }
}
