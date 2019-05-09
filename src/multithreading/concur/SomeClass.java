package multithreading.concur;

import java.util.*;

public class SomeClass {
    public static void main(String[] args) {
        // Vector
        // HashTable
        // Stack

        // однопоточные коллекции
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Map<String,Integer> map = Collections.synchronizedMap(new HashMap<>());
    }
}
