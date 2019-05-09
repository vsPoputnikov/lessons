package multithreading.pool;

import java.util.concurrent.*;

public class ExecutorServices {
    public static void main(String[] args) {
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.shutdown();

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("fixedPool"));
        singleThread.execute(new RunnableTask("fixedPool"));
        singleThread.shutdown();

        ExecutorService cachedThread = Executors.newCachedThreadPool();
        cachedThread.submit(new RunnableTask("cachedTask"));
        cachedThread.submit(new RunnableTask("cachedTask"));
        cachedThread.submit(new RunnableTask("cachedTask"));
        cachedThread.submit(new RunnableTask("cachedTask"));
        cachedThread.submit(new RunnableTask("cachedTask"));
        cachedThread.submit(new RunnableTask("cachedTask"));
        cachedThread.shutdown();

        //Отложенное выполнение
        ScheduledExecutorService sheduledServive = Executors.newSingleThreadScheduledExecutor();
        Future future1 = sheduledServive.schedule(new CallableTask("scheduledService"),5,TimeUnit.SECONDS);
        try {
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        sheduledServive.shutdown();

        // выполнение каждые 5 секунд
        ScheduledExecutorService runEveryFiveSeconds = Executors.newSingleThreadScheduledExecutor();
        runEveryFiveSeconds.scheduleAtFixedRate(new RunnableTask("runEvery5seconds"),0,5L,TimeUnit.SECONDS);
        runEveryFiveSeconds.shutdown();

        ScheduledExecutorService everySecond = Executors.newSingleThreadScheduledExecutor();
        everySecond.scheduleWithFixedDelay(new RunnableTask("every Second"),0,5,TimeUnit.SECONDS);
    }
}

class CallableTask implements Callable<Integer>{

    String name;

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Поток: " +Thread.currentThread().getName()+ name + " = "+ (2+3));
        return 2+3;
    }
}

class RunnableTask implements Runnable{
    String name;

    public RunnableTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Поток: " +Thread.currentThread().getName()+ name + " = "+ (2+3));
    }
}
