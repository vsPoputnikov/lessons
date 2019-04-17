package multithreading;

public class MultiThreadingExample {
    // start() - запуск потока
    // Thread.currentThread - получить текущий поток
    // setName() задать имя потоку
    // getName() получить имя потока
    // getState() текущее состояние
    // isAlive() - true, если поток выполняется

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

        Thread myThread = new MyThread();
        myThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(new OtherThread("Один"));
        System.out.println(thread1.getState());
        Thread thread2 = new Thread(new OtherThread("Два"));
        Thread thread3 = new Thread(new OtherThread("Три"));
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {

            System.out.println("ожидание завершения потоков");
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread2.getState());
        // инициализация анонимным классом
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running: "+ Thread.currentThread().isAlive());
                System.out.println("Running: "+ Thread.currentThread().getState());
            }
        });
        thread4.start();


       /* Thread whileThread = new WhileThread();
        whileThread.setDaemon(true);
        whileThread.start();*/

        // прерывание потоков
        // Поток останавливается в следующих случаях
        // 1. Поток выполнил все инструкции метода run и завершился
        // 2. Если в потоке было выброшено необрабатываемое исключение
        // 3. Остановка JVM
        // 4. Если это Daemon поток и основной поток завершил работу

        // у каждого потока существует флаг isInterrupted()
        // interrupt() устанавливает значение isInterrupted true и всё
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("thread5");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e){
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }

                }
            }
        });
        thread5.start();
        try {
            Thread.sleep(5000);
        } catch (Exception e){
            Thread.currentThread().interrupt();}
        thread5.interrupt();

        System.out.println("завершение основного потока");
    }
}

class WhileThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("WhileThread");
        }
    }
}

// создание класса потока
// наследование от класса Thread
class MyThread extends Thread{

    @Override
    public void run() {
        Thread.currentThread().setName("MyThread");
        System.out.println(Thread.currentThread().getName());
    }
}
// interface Runable
class OtherThread implements Runnable{
    String name;

    public OtherThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " "+ i);
        }
    }
}