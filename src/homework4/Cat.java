package homework4;

public class Cat {
    private String name;
    private int age;
    private int weight;
    private int strenght;

    public Cat(String name, int age, int weight, int strenght) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.strenght = strenght;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", strenght=" + strenght +
                '}';
    }

    public boolean fight(Cat anotherCat){
        return this.strenght>anotherCat.strenght;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }
}
