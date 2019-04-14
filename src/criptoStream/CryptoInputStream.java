package criptoStream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {
    byte[] key;
    private int currentPosition;
    public CryptoInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        int data = super.read(b);
        //
        return data;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }
}
