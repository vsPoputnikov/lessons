package streamAPI;

import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // методы получения stream объектов
        // из коллекции
//        Stream<String> stringStream = collection.stream();
//        // из массива
//        Arrays.stream(someArr);
//        // из файла
//        Files.lines(путь_к_файлу);
//        // из строки
//        "string".chars();
//        Stream.builder().add(obj).add(obj).build();
//        Stream.of(1,2,4);
        // Методы
        Stream<Integer> integerStream = Stream.of(3,6,56,56,-23,-5,0,78);
        integerStream
                .filter(integer -> integer<0 )
                .map(num->num*100)
                .limit(1)
                .forEach(System.out::println);
        integerStream = Stream.of(3,6,56,56,-23,-5,0,78);
        integerStream.distinct() // уникальные значения
        .sorted()
                .forEach(System.out::println);
        integerStream = Stream.of(3,6,56,56,-23,-5,0,78);
        System.out.format("anyMAtch: %b\n", integerStream.anyMatch(num->num>1000));
        integerStream = Stream.of(3,6,56,56,-23,-5,0,78);
        System.out.format("noneMAtch: %b\n", integerStream.noneMatch(num->num>1000));
        integerStream = Stream.of(3,6,56,56,-23,-5,0,78);
        System.out.format("allMAtch: %b\n", integerStream.allMatch(num->num>1000));

        integerStream = Stream.of(3,6,56,56,-23,-5,0,78);
        integerStream.filter(num->num<0)
                .map(num->num+"$")
                .forEach(System.out::println);

        String[] strings = {"a56","bb","ccc56","dd","f56"};
        System.out.format("Первый элемент: %s \n", Arrays.stream(strings).findFirst().orElse("Коллекция пуста"));
        System.out.format("Последний элемент: %s \n",
                Arrays.stream(strings).skip(strings.length-1).findAny().orElse("Коллекция пуста"));
        System.out.format("Элемент bb: %s \n", Arrays.stream(strings)
        .filter("bb"::equals).findFirst().get());

        System.out.format("Элементы, содержащие 56: %s \n",Arrays.stream(strings)
        .filter(s -> s.contains("56")).collect(Collectors.toList()));


        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("qwe",45));
        userArrayList.add(new User("qwe",45));
        userArrayList.add(new User("12e",4));
        userArrayList.add(new User("asde",32));
        userArrayList.add(new User("ase",45));
        userArrayList.add(new User("qzxczc",45));

        // массив пользователей старше 30
        User[] usersArr = userArrayList.stream()
                .filter(user -> user.getAge()>30)
                .toArray(User[]::new);
        System.out.println(Arrays.toString(usersArr));

        List<User> userList = userArrayList.stream().peek(user -> user.setActive(true)).collect(Collectors.toList());

        System.out.println(userList);

        userArrayList.stream().distinct().forEach(System.out::println);

        userArrayList.stream()
                .sorted(Comparator.comparing(User::getAge)).forEach(System.out::println);
        System.out.println(userArrayList.stream().min(Comparator.comparing(User::getAge)).get());
        System.out.println(userArrayList.stream().max(Comparator.comparing(User::getAge)).get());
    // Collectors
        strings =new String[] {"a56","bb","ccc56","dd","f56"};
        List<String> stringList = Arrays.stream(strings).collect(Collectors.toList());
        Set<String> setList = Arrays.stream(strings).collect(Collectors.toSet());

        ArrayList<String> stringArrayList = Arrays.stream(strings).collect(Collectors.toCollection(ArrayList::new));

       // Map<String,Integer> integerMap = Arrays.stream(strings).collect(Collectors.toMap(Function.identity(),String::length,((item,item2)->item);
//        System.out.println(integerMap);

        String string = Arrays.stream(strings).collect(Collectors.joining(":","Before: "," End"));
    }
}

class User{
    private String login;
    private int age;

    private boolean active;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        User user = (User) object;

        if (age != user.age) return false;
        if (active != user.active) return false;
        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}