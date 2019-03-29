package homework9;

import sun.dc.path.PathError;

import java.util.*;

public class Problem9_7PersonTask {
    public static void solve(){
        ArrayList<Person> persons = new ArrayList<>(PersonGenerator.generate(10));
        print(persons);
        System.out.println();
        Comparator<Person> userComparator = new UserComparator()
                .thenComparing(new UserAgeComparator())
                .thenComparing(new UserSalaryComparator());
        TreeSet<Person> sortPersons = new TreeSet<>(userComparator);
        sortPersons.addAll(persons);
        for (Person ps: sortPersons){
            System.out.println(ps);
        }
        userComparator = new UserAgeComparator().thenComparing(new UserSalaryComparator());
        sortPersons = new TreeSet<>(userComparator);
        sortPersons.addAll(persons);
        System.out.println();
        for (Person ps: sortPersons){
            System.out.println(ps);
        }
    }

    public static void print(List<Person> list) {
        System.out.println();
        for (Person pr : list) {

            System.out.println(pr);
        }
    }

}
class Person {
    String name;
    int age;
    int salary;
    String company;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public Person(String name, int age, int salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", company='" + company + '\'' +
                '}';
    }
}

class PersonGenerator {
    public static List<Person> generate(int num) {
        if (num <= 0)
            return Collections.emptyList();

        Random random = new Random();
        random.nextInt();
        List<Person> persons = new ArrayList<>(num);

       for (int i = 0; i < num; i++) {
            String name = ""+(char)(random.nextInt(25)+65)+(char)(random.nextInt(25)+97)
                    +(char)(random.nextInt(25)+97);
           String cmpn = ""+(char)(random.nextInt(25)+65)+(char)(random.nextInt(25)+65)
                   +(char)(random.nextInt(25)+65);
            persons.add(new Person(name,random.nextInt(45)+20,(random.nextInt(20)+20)*1000, cmpn));
        }
        return persons;
    }
}

class UserComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class UserSalaryComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getSalary(),o2.getSalary());
    }
}
class UserAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
class UserCompanyComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}
