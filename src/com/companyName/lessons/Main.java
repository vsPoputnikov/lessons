package com.companyName.lessons;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(); // ТипДанных имяОбъекта = new Конструктор();
        // Все пользовательские объекты создаются в куче(heap)
        Book book2 = new Book();
        // Свойства объектов
//        book1.pageCount = 34;
//        book1.title = "abc";
//        book2.pageCount = 122;
//        book2.title = "Fairy tails";
        // Геттеры и сеттеры нужны для валидации входящих данных!
        book1.setPageCount(35);
        book1.setTitle("Dem");
        book2.setPageCount(47);
        book2.setTitle("Med");

        Book book3 = new Book(22, "work");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3.getPageCount());

        Author author = new Author("Michael","Jordan");
        author.setName("Michael");
        author.setSurname("Jordan");
        book3.setAuthor(author);
        System.out.println(author);
        Book book4 = new Book(author);
        System.out.println(book4);
        Library library = new Library();
        library.addBook(book2);
        library.addBook(book1);
        System.out.println(library);
        System.out.println(library.getBook("Dem"));

    }
}
