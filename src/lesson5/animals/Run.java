package lesson5.animals;

public interface Run {
    default public  void stop(){
        System.out.println("Stop");
    }
    // методы, которые необходимо реализовать в классе
    // объектов интерфейсов не бывает
    public void run();
}
