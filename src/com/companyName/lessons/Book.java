package com.companyName.lessons;

public class Book {
    // Свойства
    int pageCount;
    String title;

    @Override
    public String toString() {
        return "Book{" +
                "pageCount=" + pageCount +
                ", title='" + title + '\'' +
                '}';
    }
}
