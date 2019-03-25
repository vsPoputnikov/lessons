package lesson6.object.nested;

public interface Logger {
    public void log();
}
class SomeClass{
    public void someVoid(){
        // Анонимный класс на основе абстрактного класса или интерфейса
        Logger logger = new Logger() {
            @Override
            public void log() {
                System.out.println("smth");
            }
        };
        logger.log();
    }
}