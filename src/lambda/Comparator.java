package lambda;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Comparator {
    public static void main(String[] args) {
        Manager alex = new Manager("Alex",34,"AGTH");
        Manager peter = new Manager("Peter",23,"QASSD");
        Manager tom = new Manager("Tom",46,"ZXC");
        Manager gloria = new Manager("Gloria",28,"ZXCH");

        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(alex);
        managers.add(peter);
        managers.add(tom);
        managers.add(gloria);

        java.util.Comparator<Manager> byName =
                java.util.Comparator.comparing(Manager::getName);
               // (manager1,manager2)->manager1.getName().compareTo(manager2.getName());
        managers.sort(byName);
        System.out.println(managers);
    }
}

class Manager{
    private String name;
    private int age;
    private String company;

    public Manager(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
