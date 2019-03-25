package lesson6.object;

public class MainObj {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object object = new Object();

        Author author = new Author("Author");
        Message message = new Message("Message text");
        message.setAuthor(author);
//        message.setMessageText();
        // Строковое представление объекта
        System.out.println(message.toString());
        // Возвращает ХэшКод: исходный адрес в памяти в 16ричной СИ
        System.out.println(author.hashCode());
        // Опции виртуальной машины:
        // -XX: hashCode = 2 // метод подсчёта хэшкода
        // -XX:+UnlockExperimentalVMOptions включение экспериментальных опций
        // equals(object o)
        Message message1 = new Message();
        message1.setAuthor(author);
        message1.setMessageText("text");

        Message message2 = new Message();
        message2.setAuthor(author);
        message2.setMessageText("text");

        System.out.println(message2.equals(message1));
        // у одинаковых объектов одинаковые хэшкоды
        // Clone метод позволяет создать копию объекта
        Message message3 =(Message) message1.clone();
    }
}
