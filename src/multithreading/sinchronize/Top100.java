package multithreading.sinchronize;

import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Top100 {
    public static void main(String[] args) throws IOException {
        // выполнить подсчёт топ 100 слов параллельно
        // количество потоков должно быть равно кол-ву доступных процессоров
        // системы
        ClassLoader loader = Top100.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());
        LinkedList<String> words= new LinkedList<>();
        TreeMap<String, Integer> wordCount = new TreeMap<>();

        List<String> lines = Files.readAllLines(file.toPath());

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // К нижнему регистру
                    .replaceAll("\\p{Punct}", " ")
                    .replaceAll("\\d","")
                    .trim()
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
        Runtime.getRuntime().availableProcessors();

        for (int i = 0; i <Runtime.getRuntime().availableProcessors() ; i++) {


            Thread thread = new Thread(new BookParser(words, wordCount));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println(wordCount.get("the"));
        Comparator<HashMap.Entry<String,Integer>> wordComparator = new Comparator<HashMap.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o1.getValue(),o2.getValue());
            }
        };

        TreeSet<Map.Entry<String,Integer>> treeSet =new  TreeSet<Map.Entry<String,Integer>>(wordComparator);

        treeSet.addAll(wordCount.entrySet());

        for (int i = 0; i < 10; i++) {
            System.out.println(treeSet.pollLast());
        }

        // общий массив на входе и отдельные мапы для потоков

        // Пиццерия
        // Клиент(main), официант, повар
        // Официант и повар спят без клиентов
        // клиент оставляет заказ, будит официанта,
        // официант передаёт заказ повару и будит его
        // Повар готовит, возвращает блюдо.
        // После выполнения операций поток засыпает
    }
}



class BookParser implements Runnable{
    LinkedList<String> words;
    TreeMap<String, Integer> wordCount;

    public BookParser(LinkedList<String> words, TreeMap<String, Integer> wordCount) {
        this.words = words;
        this.wordCount =wordCount;
    }

    synchronized void moveToCount(){
        while(!words.isEmpty()){
            String word = words.poll();
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else{
                wordCount.put(word, 1);
            }

        }

    }
    @Override
    public void run() {
        moveToCount();
    }
}
