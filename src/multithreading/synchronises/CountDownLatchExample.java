package multithreading.synchronises;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final CountDownLatch START = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <3 ; i++) {
            new Thread(new Runner(2000)).start();
        }

        while(START.getCount()>3){
            Thread.sleep(1000);
        }

        Thread.sleep(1000);
        System.out.println("На старт"); // событие
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Внимание");
        START.countDown();
        Thread.sleep(1000);
        System.out.println("Go!!!");
        START.countDown();
    }

public static class Runner implements Runnable{

    long sleep;

    public Runner(long sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        System.out.println("Бегун " + Thread.currentThread().getName()+ " на старте");
        START.countDown(); // уменьшение счётчика
        try {
            START.await();// блокирует поток, пока значение счётчика не будет равно 0
            Thread.sleep(sleep);
            System.out.println("Бегун " + Thread.currentThread().getName()+ " finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}

