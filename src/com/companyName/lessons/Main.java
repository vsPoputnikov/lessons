package com.companyName.lessons;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(); // ТипДанных имяОбъекта = new Конструктор();
        // Все пользовательские объекты создаются в куче(heap)
        Book book2 = new Book();
        // Свойства объектов
        book1.pageCount = 34;
        book1.title = "abc";
        book2.pageCount = 122;
        book2.title = "Fairy tails";
        System.out.println(book1);
        System.out.println(book2);
    }
}
