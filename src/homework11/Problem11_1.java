package homework11;

import java.io.*;
import java.util.Scanner;

public class Problem11_1 {
    public static void copyFile(String inF, String outF)throws IOException {

        File inFile = new File(inF/*+in.nextLine()*/);
        File outFile = new File(outF);
        try(FileInputStream inputStream = new FileInputStream(inFile);
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)
        ){

            System.out.println(inputStream.available());
            byte[] buffer = new byte[4];
            byte code = 'a';
            int len, count=0;
            while((len = inputStream.read(buffer))>0){

                outputStream.write(buffer,0,len);
                count+=len;
            }
            System.out.println(count);

        }
    }
}
