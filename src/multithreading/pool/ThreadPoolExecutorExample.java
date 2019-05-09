package multithreading.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,
                10, 2, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3));
        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task());
        queue.add(new Task2());
        queue.add(new Task());
        for (Runnable runnable : queue) {
            pool.execute(runnable);
        }
        pool.shutdown();
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task is running " + Thread.currentThread().getName());
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task is running " + Thread.currentThread().getName());
    }
}
