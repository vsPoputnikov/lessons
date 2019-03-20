package lesson5.animals;

public class Mouse extends Animal implements Run {
    @Override
    public void run() {
        System.out.println("Run");
    }

    @Override
    public void stop() {
        System.out.println("Mouse stop");
    }
}
