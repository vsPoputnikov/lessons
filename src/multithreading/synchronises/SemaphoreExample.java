package multithreading.synchronises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new IncrementThread("Increment", semaphore);
        new DecrementThread("Decrement", semaphore);


    }
}

class Counter {
    static int count= 0;
}

class IncrementThread implements Runnable{
    String name;
    Semaphore semaphore;

    public IncrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск работы "+ name);

        try {
            System.out.println("Ожидание разрешения потоком "+ name);
            semaphore.acquire();
            System.out.println("Поток "+ name+" разрешение получил");
            for (int i = 0; i < 5 ; i++) {
                Counter.count++;
                System.out.println("Counter.count = "+Counter.count);
            }
            System.out.println("Поток " + name + "больше не нужно разрешение");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}


class DecrementThread implements Runnable{
    String name;
    Semaphore semaphore;

    public DecrementThread(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Запуск работы "+ name);

        try {
            System.out.println("Ожидание разрешения потоком "+ name);
            semaphore.acquire();
            System.out.println("Поток "+ name+" разрешение получил");
            for (int i = 0; i < 5 ; i++) {
                Counter.count--;
                System.out.println("Counter.count = "+Counter.count);
            }
            System.out.println("Поток " + name + "больше не нужно разрешение");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();

    }
}