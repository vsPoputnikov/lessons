package homework10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Homework10 {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = Homework10.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());

        List<String> lines = Files.readAllLines(file.toPath());

        File file2 = new File(loader.getResource("articles.txt").getFile());

        List<String> articles = Files.readAllLines(file2.toPath());

        List<String> words = new ArrayList<>();

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

        List<String> wordsCopy = new ArrayList<>(words);
        // Считаем количество вхождений
        TreeMap<String, Integer> treeMap = new TreeMap<>();


       /* for (int i = 0; i <words.size() ; i++)
        {
            String word = words.get(i);
            int count = 0;
            for (int j = 0; j <words.size() ; j++) {
                if(words.get(j).equals(word)){
                    count++;
                    }
            }
            if(!treeMap.containsKey(word))
            treeMap.put(word,count);
        }*/
        while (wordsCopy.size() > 0) {
            String word = wordsCopy.get(0);
            wordsCopy.remove(0);
            int count = 1;
            for (int j = 0; j < wordsCopy.size(); j++) {
                if (wordsCopy.get(j).equals(word)) {
                    count++;
                    wordsCopy.remove(j);
                    j--;
                }
            }
            treeMap.put(word, count);
        }
        // Группы по длине
        HashMap<Integer, HashSet<String>> wordsByLength = new HashMap<>();
        for (String word : words) {
            int key = word.length();
            if (!wordsByLength.containsKey(key)) {
                wordsByLength.put(key, new HashSet<>());
            }
            wordsByLength.get(key).add(word);
        }

        TreeMap<String, Integer> treeArticlesMap = new TreeMap<>(treeMap);
        for (String entry : articles) {
            treeArticlesMap.remove(entry);
        }

        treeMap.remove("asdasdsasdasdasdasdad");
        System.out.println(treeMap.get("just"));
        System.out.println(treeArticlesMap.get("just"));
        System.out.println(treeMap.get("because"));
        System.out.println(treeArticlesMap.get("because"));
        // System.out.println(wordsByLength.get(7));
        Comparator<Map.Entry<String, Integer>> userComp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };
        TreeSet<Map.Entry<String, Integer>> sortedMap = new TreeSet<Map.Entry<String, Integer>>(userComp);
        sortedMap.addAll(treeMap.entrySet());
        for (int i = 0; i < 10; i++) {
            System.out.println(sortedMap.pollLast());
        }

        ArrayList<Character> chars = new ArrayList<>();
        for (String word : words) {
            char[] chrs = word.toCharArray();
            for (char ch : chrs)
                chars.add(ch);
        }

        double size = chars.size();

        TreeMap<Character,Double> charSet = new TreeMap<>();
        while (chars.size() > 0) {
            char ch = chars.get(0);
            chars.remove(0);
            int count = 1;
            for (int j = 0; j < chars.size(); j++) {
                if (chars.get(j).equals(ch)) {
                    count++;
                    chars.remove(j);
                    j--;
                }
            }
            charSet.put(ch, (count/size));
        }

        System.out.println(charSet);
    }
}
