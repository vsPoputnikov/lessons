package multithreading.concur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentExample {
    // потокобезопасные коллекции
    // блокирующие и неблокирующие очереди
    // пул потоков
    // альтернативный wait() notify() synchronised

    public static void main(String[] args) {
        LinkedBlockingQueue queue;// можно указать размер
        LinkedBlockingDeque deque;
        LinkedTransferQueue transferQueue;// кроме размера можно задать таймаут

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(19, true); // Неизменный размер


        PriorityBlockingQueue priorityBlockingQueue;// Сортировка
        SynchronousQueue synchronousQueue;// очередь на один элемент






       // CopyOnWriteArraySet вместо ArrayList
        ConcurrentHashMap<String,Integer> map;
        //
        ConcurrentSkipListMap<String,Integer> map1 = null;//TreeMap
        map1.putIfAbsent("qwe",4);
        map1.remove("qwe",4);
        map1.replace("qwe",4,78);
        ConcurrentSkipListSet<String> set;//
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("qwe");
        list.add("asd");
        list.add("zxc");
        list.add("rty");

        new WriteThread(list).start();
        new ReadThread(list).start();

    }
}

class WriteThread extends Thread{
    private List<String> list;
    private ArrayList<String> data = new ArrayList<>();

    public WriteThread(List<String> list){
        this.list = list;
        data.add("qwe");
        data.add("asd");
        data.add("zxc");
        data.add("rty");
    }

    @Override
    public void run() {
        int count = 0;

        while (true) {
            if(data.size()-1==count) count =0;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        list.add(data.get(count));
            count++;
            System.out.println("Write Thread added");
        }
    }



}

class ReadThread extends Thread{
    private List<String> list;
    public ReadThread(List<String> list){
        this.list = list;
    }


    @Override
    public void run() {
        while(true){
            String res = "ReadThread res: ";
            for(String str: list){
                if(list.contains("asd")){
                    list.remove(str);
                }
                res+=str+" ";
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(res);


           /* Iterator<String> iterator = list.iterator();
            while(iterator.hasNext()){
                String next = iterator.next();
                res+=next + " ";
            }
            System.out.println(res);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/


        }
    }
}