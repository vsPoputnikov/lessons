package lesson11.exceptions.exceptions.io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class IOExample {
    
   /* try{

    }
   */ // IO| NIO

    // IO API

    public static void main(String[] args) {
// Работают с байтами
        //        InputStream
//                OutputStream
//        Работают с char
//        Reader
//        Writer
        File file = new File("src/file.txt");
        try {
        readByte(file);
        } catch (IOException e){
            e.printStackTrace();
        }

        /*try {
            long l = readByte(file);
        } catch (IOException e){
            e.printStackTrace();
        }



        try {
            writeToFile("src/file.txt", true, Charset.forName("UTF-8"));
        } catch (IOException e){
            e.printStackTrace();
        }*/
    }

    public static long readByte(File file)throws IOException{
        //FileInputStream
        long summ=0;
        try(FileInputStream inputStream = new FileInputStream(file)){
            System.out.println(inputStream.available());
            while(inputStream.available()>0){
                int data = inputStream.read();
                summ+=data;
                System.out.println((char)data);
            }
            System.out.println(summ);
        return summ;

        }






    }

    public static void writeToFile(String fileName, boolean append, Charset charset) throws IOException {
        //  FileOutputStream Нужно закрывать либо в try()
        try (FileOutputStream outputStream = new FileOutputStream(fileName, append)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append("line ").append(i).append("\n");
            }
            byte[] bytes = sb.toString().getBytes(charset);
            outputStream.write(bytes);

        }
    }
    
    public static void readByteArray(File file, Charset charset) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream() ){
            byte[] buff = new byte[10];
            int len;
            while ((len = fileInputStream.read(buff))>0){
                System.out.println(Arrays.toString(buff));
                byteArrayOutputStream.write(buff,0,len);
            }
            System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
            System.out.println(new String(byteArrayOutputStream.toByteArray(),charset));
        }
    }

    public static void writeWithBuffer(File file)throws IOException{
        // Декоратор
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)
        ){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append("line ").append(i).append("\n");
            }
            byte[] buffer = sb.toString().getBytes();
            outputStream.write(buffer,0, buffer.length);

        }
    }

    public static void readFromSeveralFiles(File[] files, Charset charset)throws IOException{
        try (
                FileInputStream inputStream1 = new FileInputStream(files[0]);
             FileInputStream inputStream2 = new FileInputStream(files[1]);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()
        ){
            SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1,inputStream2);
            byte[] buf = new byte[1024];
            int len;

            while((len = sequenceInputStream.read(buf))>0){
                byteArrayOutputStream.write(buf,0,len);
            }
        }
    }

    public static String readChar(InputStream in, Charset charset)throws IOException{
        InputStreamReader reader = new InputStreamReader(in);
        char[] buf = new char[128];
        int len = buf.length;
        StringBuilder sb = new StringBuilder();
        while ((len - reader.read(buf))>0){
            sb.append(buf,0,len);
        }
        return sb.toString();
    }



}
