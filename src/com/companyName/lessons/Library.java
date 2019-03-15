package com.companyName.lessons;

import java.util.Arrays;

public class Library {
    private Book[] books = new Book[10];

    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }

    public void addBook(Book book) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = book;
                break;
            }
        }

    }

    public Book getBook(String bookTitle) {
        Book result = null;
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getTitle().equals(bookTitle)) {
                result = books[i];
                break;
            }
        }
        return result;
    }
    
//    public void rmBook(String "title"){
//        for (int i = 0; i < ; i++) {
//
//        }
//    }
}
