package criptoStream;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {
    private byte[] key;
    private int currentKeyPosition;

    public CryptoOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
        this.currentKeyPosition=0;
    }

    @Override
    public void write(int b) throws IOException {

        super.write((this.key[currentKeyPosition]^(byte)b));
        currentKeyPosition=(currentKeyPosition+1)%(key.length);
    }




    @Override
    public void write(byte[] b) throws IOException {

       for (int i = 0; i < b.length ; i++) {

           System.out.println( b[i]);
        }
        super.write(b);
    }
}
