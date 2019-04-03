package homework11;

import java.io.IOException;
import java.util.Scanner;

public class Homework11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
           // Problem11_1.copyFile("resourses/hw11in.txt","resourses/hw11out.txt");
           // Problem11_2.splitFile("resourses/hw11in.txt",4);
            String[] files = {"resourses/hw11in_0.txt","resourses/hw11in_1.txt","resourses/hw11in_2.txt"};
            Problem11_2.glueFile(files,"resourses/hw11glue.txt");
        }catch (IOException e){
            e.printStackTrace();
        };
    }
}
