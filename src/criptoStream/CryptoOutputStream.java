package criptoStream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CryptoOutputStream extends FilterOutputStream {
    public CryptoOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int b) throws IOException {

        super.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }

    private byte[] key;
    private int currentKeyPosition;
    @Override
    public void write(byte[] b) throws IOException {
        super.write(b);
    }
}
