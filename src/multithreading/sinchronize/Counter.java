package multithreading.sinchronize;

import java.util.ArrayList;

public class Counter {
    int counter = 0;

    // Синхронизированный метод

    public synchronized void increment(){
        counter++;
    }
}

class IncrementThread extends Thread{
    Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {

            counter.increment();

            // синхронный блок(синхронизация по объекту)
           /* synchronized (counter) {
                counter.counter++;
            }*/
        }
    }
}

class Main{
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        ArrayList<IncrementThread> threads = new ArrayList<>();
        //создаём потоки
        for (int i = 0; i < 100 ; i++) {
            threads.add(new IncrementThread(counter));
        }

        // запуск потоков
        for(IncrementThread thread: threads){
            thread.start();
        }

        // ждём завершения
        for(IncrementThread thread: threads){
            thread.join();
        }
        System.out.println(counter.counter);
    }
}