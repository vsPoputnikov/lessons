package homework11;

import java.io.*;
import java.util.Vector;

public class Problem11_2 {
    public static void splitFile(String inF, int size) throws IOException{
        File inFile = new File(inF);
        try(FileInputStream inputStream = new FileInputStream(inF);){
              int count = inputStream.available()/size;
              if ((inputStream.available()%size)>0)
                  count++;
            for (int i = 0; i <count ; i++) {
                try(FileOutputStream fileOutputStream =
                            new FileOutputStream(inF.substring(0,inF.lastIndexOf('.'))+"_"+i+".txt");
                    BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)){
                    byte[] buffer = new byte[size];
                    int len;
                    len = inputStream.read(buffer);
                        outputStream.write(buffer,0,len);
                        System.out.println(len);

                }
            }
        }
    }

    public static void glueFile(String[] files,String outF) throws IOException{
        try(FileOutputStream fileOutputStream =
                    new FileOutputStream(outF);
            BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream)){
            Vector<InputStream> sequence = new Vector<>();
            for (String file: files){
                InputStream inputStream = new FileInputStream(file);
                sequence.add(inputStream);
            }
            SequenceInputStream sequenceInputStream = new SequenceInputStream(sequence.elements());
            byte[] buf = new byte[1024];
            int len;

           while((len = sequenceInputStream.read(buf))>0){
               System.out.println(len);
               outputStream.write(buf,0,len);
            }
           for(InputStream inStream: sequence){
               inStream.close();
           }



        }
    }


}
