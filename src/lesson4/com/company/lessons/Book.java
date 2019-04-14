package lesson4.com.company.lessons;

public class Book {
    // Свойства
    private int pageCount;
    private String title;
    private Author author;

    Book(Author author){
        this.author = author;
    }
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    // default constructor
    public Book() {
    }

    public Book(int pageCount){
        this.setPageCount(pageCount);
    }

    public Book(int pageCount, String title){
        this.setPageCount(pageCount);
        this.setTitle(title);
    }


    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        // Проверка входящих данных
        if (pageCount<1){
            System.out.println("ошибка количества страниц");
            return; // выполнение метода прерывается
        }
        this.pageCount = pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pageCount=" + pageCount +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
