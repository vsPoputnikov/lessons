package homework4;

public class Dog {
    private String name = "Dog";
    private int weight = 12;
    private int age = 5;
    private String color;
    private String address;

    Dog(String name){
        this.setName(name);
    }

    Dog(String name, int weight, int age){
        this.setName(name);
        this.setWeight(weight);
        this.setAge(age);
    }
    Dog(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    public Dog(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Dog(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
