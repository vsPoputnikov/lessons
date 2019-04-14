package homework11;

import homework10.Homework10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Problem11_4 {
    public static void solve() throws IOException {
        ClassLoader loader = Homework10.class.getClassLoader();
        File file = new File(loader.getResource("hw11in.txt").getFile());
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase() // К нижнему регистру
                    .trim()
                    .split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }
        ArrayList<Character> chars = new ArrayList<>();
        for (String word : words) {
            char[] chrs = word.toCharArray();
            for (char ch : chrs)
                chars.add(ch);
        }
        TreeMap<Character,Double> charSet = new TreeMap<>();
        for(char ch:chars){
            if(charSet.containsKey(ch))
            {charSet.put(ch,charSet.get(ch)+1);}
            else {charSet.put(ch,1d);}
        }
        System.out.println(charSet.get(','));
    }
}
