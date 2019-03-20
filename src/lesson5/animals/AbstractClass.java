package lesson5.animals;

public abstract class AbstractClass implements SomeInterface {

    public  abstract void abstractVoid();
    public void someVoid(){
        System.out.println("spme void");
    }
}

interface SomeInterface{
    public void iVoid();
}

class someClass extends AbstractClass{
    // должен реализовать абстрактные методы интерфейса абстрактного класса

    @Override
    public void iVoid() {

    }

    @Override
    public void abstractVoid() {
        System.out.println("реализация метода абстрактного класса");
    }
}
