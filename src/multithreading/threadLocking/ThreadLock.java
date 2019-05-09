package multithreading.threadLocking;

public class ThreadLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 START");
                synchronized (obj1){
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){}
                    System.out.println("obj1 locked");
                    synchronized (obj2){
                        System.out.println("obj2 locked");

                    }
                }

            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 START");
                synchronized (obj1){
                    try {
                        Thread.sleep(500);
                    }catch (Exception e){}
                    System.out.println("obj1 locked");
                    synchronized (obj2){
                        System.out.println("obj2 locked");

                    }
                }

            }
        });

        thread1.start();
        thread2.start();

    }
}
