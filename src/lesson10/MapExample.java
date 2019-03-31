package lesson10;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        HashMap<String,User> userHashMap = new HashMap<>();
        User user1 = new User("qwe", "111");
        User user2 = new User("asd", "222");
        User user3 = new User("zxc", "333");
        User user4 = new User();
        userHashMap.put(user1.getLogin(), user1);
        userHashMap.put(user2.getLogin(), user2);
        userHashMap.put(user3.getLogin(), user3);
        userHashMap.put(null, user4);

        userHashMap.keySet();
        userHashMap.values();
        System.out.println(userHashMap.get("asd"));
        for (Map.Entry entry: userHashMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        //LinkedHashMap с сохранением порядка
        //EnumMap(enum в качестве ключей)
        EnumMap<State, String> enumMap = new EnumMap<State, String>(State.class);
        enumMap.put(State.ERROR, "ERROR");// null запрещён в качестве ключа
        enumMap.put(State.START, "START");
        enumMap.put(State.STOP, "Stop");

        System.out.println(enumMap.get(State.ERROR));

        // сортировано по ключам
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3,"3");
        treeMap.put(1,"1");
        treeMap.put(2,"2");
        treeMap.put(6,"6");
        System.out.println(treeMap);


        Object obj = new Object();
        WeakReference weakReference = new WeakReference(obj);
        WeakHashMap<Object,String> weakHashMap = new WeakHashMap<>();

        HashMap<Object, String> hashMap = new HashMap<>();
        Object hashKey = new Object();
        String hashValue = "HashValue";

        Object weakKey = new Object();
        String weakValue = "HashValue";

        weakHashMap.put(weakKey,weakValue);
        hashMap.put(hashKey, hashValue);

        System.out.println("Weak" + weakHashMap);
        System.out.println("hash"+ hashMap);

        hashKey = null;
        weakKey = null;
        System.gc();

        System.out.println("Weak" + weakHashMap);
        System.out.println("hash"+ hashMap);

        // ключи сравниваются с помощью операции == (не метода equals)
        //IdentityHashMap<> используется для клонирования и сериализации

        HashMap<String, Integer> map = new HashMap<>();
        map.put("qwe", 23);
        map.put("asd", 3);
        map.put("sdf", 223);
        map.put("dfg", 233);
        map.put("fgh", 234);
        map.put("ghj", 235);
        /*for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()<20){
                map.remove(entry.getKey());
            }
        } EXEPTION*/

        Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            String key = entry.getKey();
            int val = entry.getValue();

            if (val < 20){
                iterator.remove();
            }
        }

    }
}

enum State {
    START, STOP, ERROR;
}

class User{
    String login;
    String pwd;

    public User() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override // нужно переопределить, если объекты являются ключами
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }
}
