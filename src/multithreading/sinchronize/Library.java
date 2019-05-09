package multithreading.sinchronize;

import Lesson8.Book;

public class Library {
    public static void main(String[] args) {
        BookStorage storage = new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();
    }
}

class BookStorage{
    int booksCount = 0;
    public synchronized void getBook()throws InterruptedException {
        System.out.println("getBook - начало выполнения");
        while (booksCount<1){

                wait();

            System.out.println("getBook waiting...");
        }
        booksCount--;
        System.out.println("1 забрали, осталось "+booksCount);
    }
    public synchronized void putBook()throws InterruptedException{
        System.out.println("putBook - начало");
        while(booksCount>=5){
            wait();
            System.out.println("putBook waiting");
        }
        booksCount++;
        System.out.println("1 добавили в хранилище " + booksCount);
        System.out.println("end of method putBook");
        notify(); // разбудит случайный поток
    }

}

class PutThread implements Runnable{
    BookStorage storage;

    public PutThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {


            for (int i = 0; i < 10; i++) {
                storage.putBook();
            }
        } catch (Exception e){}
    }


}

class GetThread implements Runnable{
    BookStorage storage;

    public GetThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                storage.getBook();
            }
        } catch (Exception e){}
    }
}