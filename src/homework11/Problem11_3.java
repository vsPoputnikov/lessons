package homework11;

import java.io.*;

public class Problem11_3 {
    public static void codeFileByPass(String inF, String outF, String password) throws IOException {

        File inFile = new File(inF/*+in.nextLine()*/);
        File outFile = new File(outF);
        try (FileInputStream inputStream = new FileInputStream(inFile);
             FileOutputStream fileOutputStream = new FileOutputStream(outFile);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)
        ) {

            System.out.println(inputStream.available());
            byte[] buffer = new byte[4];
            int len, count = 0;
            byte[] code = null;

            byte[] pass = password.getBytes();
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ pass[i % pass.length]);
                }
                outputStream.write(buffer, 0, len);
            }


        }
    }

    public static void codeFileByFile(String inF, String outF, String passFile) throws IOException {

        File inFile = new File(inF/*+in.nextLine()*/);
        File outFile = new File(outF);
        File passFil = new File(passFile);
        try (FileInputStream inputStream = new FileInputStream(inFile);
             FileInputStream inputStremPass = new FileInputStream(passFil);
             FileOutputStream fileOutputStream = new FileOutputStream(outFile);
             BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)
        ) {

            System.out.println(inputStream.available());
            byte[] buffer = new byte[4];
            int len, count = 0;
            byte[] code = null;
            int passlen = inputStremPass.available();
            System.out.println(inputStremPass.markSupported());
            inputStremPass.mark(123);
            System.out.println(inputStremPass.markSupported());
            byte[] pass = new byte[123];

            while ((len = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < len; i++) {
                    passlen = inputStremPass.read(pass);
                    System.out.println(pass);
                    buffer[i] = (byte) (buffer[i] ^ pass[i % passlen]);
                    if(i%passlen==0){
                        //inputStremPass.reset();
                    }
                }
                outputStream.write(buffer, 0, len);
            }


        }
    }
}
