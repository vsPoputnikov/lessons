package lesson9;

import sun.reflect.generics.tree.Tree;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) throws IOException {
        ArrayList<Book>  bookArrayList = new ArrayList<>();
       // ArrayList<Book>  bookArrayList2 = new ArrayList<>(4);
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Cars"));
        bookArrayList.add(2, new Book("Alfabet"));

        for (Book book: bookArrayList){
            System.out.println(book.getTitle());
        }
        // порядок элементов не сохраняется
        Set<Book> bookSet = new HashSet<>(bookArrayList); // нужны перегрузки к equals & hashcode
        System.out.println("bookSet");
        for(Book book:bookSet){
            System.out.println(book.getTitle());
        }

        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(new Book("Book 1"));
        bookLinkedList.add(new Book("Book 2"));
        bookLinkedList.add(new Book("Book 3"));

        for(Book book:bookLinkedList){
            System.out.println(book.getTitle());
        }

        TreeSet<String> strings = new TreeSet<>();
        strings.add("Hello");
        strings.add("Hi");
        strings.add("Asd");
        strings.add("asd");

        for (String str: strings){
            System.out.println(str);
        }

        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(new Book("Book 1"));
        bookTreeSet.add(new Book("Book 2"));
        System.out.println(bookTreeSet);

        User user1 = new User("qwe", 123);
        User user2 = new User("wer", 13);
        TreeSet<User> users = new TreeSet<>(new UserComparator());
        users.add(user1);
        users.add(user2);

        Comparator<User> userComparator = new UserNameComparator()
                .thenComparing(new UserAgeComparator());
        TreeSet<User> userTreeSet = new TreeSet<>(userComparator);
        userTreeSet.add(new User("Qwe",34));
        userTreeSet.add(new User("Qwe",12));
        userTreeSet.add(new User("Tom",34));
        userTreeSet.add(new User("Alex",56));

        for (User user: userTreeSet){
            System.out.println(user.getName() + " " + user.getAge());
        }

        ClassLoader loader = CollectionExample.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());

        // читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());

        List<String> words = new ArrayList<>();

        for(String line: lines){
            String[] wordSplit = line.toLowerCase() // К нижнему регистру
                                    .replaceAll("\\p{Punct}", " ")
                                    .trim()
                                    .split("\\s");
            for (String s: wordSplit){
                if (s.length()>0)
                words.add(s.trim());
            }
        }

        for(String word: words){
            System.out.println(word);
        }
        //LinkedHashSet<> хранит по порядку добавления
    }
}


// для дерева нужен интерфейс сравниваемый....
class Book implements Comparable<Book> {
    String title;
    // если 0, то объекты равны
    // отрицательное, если предшествует
    // положительное, если идёт после
    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.getTitle());
    }

    public String getTitle() {
        return title;
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

class User{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class UserComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class UserNameComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class UserAgeComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}

// ДЗ: добавить в качестве свойства свой объект и запихнуть в трисет
// Сделать внутренний класс Билдер! в метод передаётся количество человек и получается на выходе коллекция рандомных...
// Сортировки в разном порядке... name; name->age->salary; name->age;
class Person {
    String name;
    int age;
    int salary;
    String company;
}