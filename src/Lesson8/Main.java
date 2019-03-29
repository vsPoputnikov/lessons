package Lesson8;

public class Main {
    public static void main(String[] args) {
        Book tails = new Book("tails", 34);
        Book flowers = new Book("flowers", 56);

        Car car = new Car("red");

       /* MyList bookStorage = new MyList();
        bookStorage.addLast(tails);
        bookStorage.addLast(flowers);

        bookStorage.addLast(car);*/

        // Написать доступ по индексу!
        //Object bookFromStorage1 = (Book)bookStorage.get(0);
        //System.out.println(bookFromStorage1.getTitle());

       // Book bookFromStorage2 = (Book) bookStorage.get(2);
       // System.out.println(bookFromStorage2.getTitle());
        MyList<Book> bookStorage = new MyList<>();
        bookStorage.addFirst(tails);
        bookStorage.addLast(flowers);

       // bookStorage.addLast(car);
        MyList<ChildBook> childBookMyList = new MyList<>();
        ChildBook coloring = new ChildBook("coloring", 23);
        childBookMyList.addLast(coloring);
    }
     // со всеми потомками
    public static Book getFirstBook(MyList<? extends Book> storage){
        ChildBook book = new ChildBook("Book", 12);
        // так нельзя... на момент компилляции неизвестен тип
        //storage.addLast(book);
        return storage.get(0);

    }
    // со всеми предками и book
    public void addToStorage(MyList<? super Book> storage){
        Book book = new Book("Book",234);
        storage.addLast(book);
//        не знает, что в хранилище
//        Book book1 = storage.get();
        Object o = storage.get(0);
        System.out.println(o);
    }
    // Дженерики доступны только на этапе компиляции..
    // Перегружать ими нельзя, это будет один и тот же метод!
   // public void someVoid(MyList<String> storage){};
    public void someVoid(MyList<Integer> storage){}

//    В статике не используем
    //public static T staticVoid(){};


    public static void storage(MyList<?> storage){
        Book book = new Book("Book",234);
        //storage.addLast(book);
        storage.addLast(null);
        //Book book1 = storage.get(0);
        Object o = storage.get(0);
    }
}
