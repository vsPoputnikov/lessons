package criptoStream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {
    byte[] key;
    private int currentKeyPosition;
    public CryptoInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
        currentKeyPosition=0;
    }

    @Override
    public int read() throws IOException {
        byte b = (byte)super.read();
        b= (byte) (b^key[currentKeyPosition]);
        currentKeyPosition=(currentKeyPosition+1)%(key.length);
        return b;

    }

    @Override
    public int read(byte[] b) throws IOException {
        int r = super.read(b);
        for (int i = 0; i <b.length ; i++) {
            b[i]=(byte)(b[i]^key[currentKeyPosition]);
            currentKeyPosition=(currentKeyPosition+1)%(key.length);
        }




        return r;
    }


}
