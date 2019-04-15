package criptoStream;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte[] key = "w123123wss".getBytes();
        File in = new File("resourses/hw11coded.txt");

        try(CryptoInputStream cis = new CryptoInputStream(new FileInputStream(in),key);
        CryptoOutputStream cos = new CryptoOutputStream(new FileOutputStream(in),key);
        FileInputStream inPure = new FileInputStream(in)){
            //System.out.println('d'^'w');
            String word = "dddddd123";
            byte[] wrd = word.getBytes();
            cos.write(word.getBytes());
            int len = cis.available();
            byte[] bytes = new byte[len];
            cis.read(bytes);
            System.out.println(Arrays.toString(bytes));
            for (int i = 0; i < len ; i++) {


                System.out.println((char)bytes[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
