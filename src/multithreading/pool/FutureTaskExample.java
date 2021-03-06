package multithreading.pool;

import patterns.dao.User;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {
        Callable<UserInfo> callable1 = new CreateUser(2000);
        Callable<UserInfo> callable2 = new CreateUser(3000);

        FutureTask<UserInfo> futureTask1 = new FutureTask<>(callable1);
        FutureTask<UserInfo> futureTask2 = new FutureTask<>(callable2);

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(futureTask1);
        service.execute(futureTask2);

        while (true){
            if (futureTask1.isDone()&&futureTask2.isDone()){
                System.out.println("Задачи выполнены");
                service.shutdown();
                return;
            }

            if(futureTask1.isDone()){
                try {
                    System.out.println("futureTask result: " + futureTask1.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println("Ожидание завершения futureTask2...");



                try {
                    UserInfo userInfo = null;
                    userInfo = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                    if(userInfo!=null){
                        System.out.println("futureTask result: " + futureTask2.get());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }



            }
        }
    }
}

class UserInfo{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}

class CreateUser implements Callable<UserInfo>{

    public CreateUser(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    long sleepTime;

    @Override
    public UserInfo call() throws Exception {
        Thread.sleep(sleepTime);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(Thread.currentThread().getName());
        return userInfo;
    }
}