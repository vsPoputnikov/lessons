package homework16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Semaphore;

public class TwoThreadsOneFile {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        File file = new File("log.txt");
        FileWriter fw1 =  new FileWriter(semaphore, file);
        FileWriter2 fw2 =  new FileWriter2(semaphore, file);
        new Thread(fw1).start();
        new Thread(fw2).start();


    }

}
class FileWriter implements Runnable{
    Semaphore semaphore;
    File file;

    public FileWriter(Semaphore semaphore, File file) {
        this.semaphore = semaphore;
        this.file = file;
    }

    @Override
    public void run() {
    int j = 0;
        try {
            while(j++<10) {
                semaphore.acquire();

                FileOutputStream fout = new FileOutputStream(file, true);

                fout.write('1');
                fout.write('\n');
                for (int i = 0; i < 5; i++) {
                    fout.write('0' + i);
                }

                fout.write('\n');
                fout.flush();
                semaphore.release();
                Thread.sleep(1500);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class FileWriter2 implements Runnable{
    Semaphore semaphore;
    File file;

    public FileWriter2(Semaphore semaphore, File file) {
        this.semaphore = semaphore;
        this.file = file;
    }

    @Override
    public void run() {
        int j = 0;
        try {
            while(j++<10) {
                semaphore.acquire();

                FileOutputStream fout = new FileOutputStream(file, true);

                fout.write('2');
                fout.write('\n');
                for (int i = 0; i < 5; i++) {
                    fout.write('0' + i);
                }

                fout.write('\n');
                fout.flush();
                semaphore.release();
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}