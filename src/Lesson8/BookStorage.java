package Lesson8;

interface SomeInterface<T>{
    public T getData();
}
public class BookStorage<T extends Book> implements SomeInterface<T>/*Нужно указывать, иначе возвращать будет object*/ {
    private T book;

    @Override
    public T getData() {
        return null;
    }

    public T getBook() {
        return book;
    }

    public String getBookTitle(){
        return book.getTitle();
    }
}
