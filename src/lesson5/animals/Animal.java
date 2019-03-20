package lesson5.animals;

public class Animal implements Run,Eat{
    protected String color;
    protected int age;

    @Override
    public void eat(Animal animal) {

    }

    @Override
    public void run() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
