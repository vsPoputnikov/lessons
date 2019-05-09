package streamAPI;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.*;
import java.util.stream.Collectors;

public class TstMain {
    public static void main(String[] args) {
        Author mike = new Author("Mike", 34);
        Author peter = new Author("Peter", 12);
        Author alice = new Author("Alice", 67);
        Author tom = new Author("Tom", 33);
        Author jane = new Author("Jane", 17);

        Article article1 = new Article("Java 12",tom, Article.Category.JAVA);
        Article article2 = new Article("fr Java 8 to 9",peter, Article.Category.JAVA);
        Article article3 = new Article("Python parsing",alice, Article.Category.PYTHON);
        Article article4 = new Article("Frameworks",tom, Article.Category.PHP);
        Article article5 = new Article("DB",alice, Article.Category.PHP);
        Article article6 = new Article("Local Variables",jane, Article.Category.JAVA);
        Article article7 = new Article("Flask, Pony",mike, Article.Category.PYTHON);
        Article article8 = new Article("Lambda",peter, Article.Category.JAVA);
        Article article9 = new Article("new GC",tom, Article.Category.JAVA);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        articles.add(article8);
        articles.add(article9);

        // статьи по автору
        articles.stream().collect(Collectors.groupingBy(a->a.getAuthor().getName()))
                .entrySet() // Set<Entry<String, List<Article>>>
        .forEach(System.out::println);

        // вывести имена авторов по алфавиту
        articles.stream().map(article -> article.getAuthor().getName()).distinct().sorted().forEach(System.out::println);

        // Количество статей по каждому автору
        articles.stream().collect(Collectors.groupingBy(a->a.getAuthor().getName(),Collectors.counting()))
                .forEach((a,count)->System.out.println(a + " : " + count));

        Map<Article.Category, Map<String, List<Article>>> map = articles.stream()
                .sorted(Comparator.comparing(Article::getCategory,Comparator.comparing(Enum::name))
                                                                .thenComparing(a->a.getAuthor().getName()))
                .collect(Collectors.groupingBy(Article::getCategory,
                        LinkedHashMap::new, Collectors.groupingBy(a->a.getAuthor().getName())));

        System.out.println(map);

ArrayList<Author> authors = new ArrayList<>();
authors.add(mike);
        authors.add(peter);
        authors.add(jane);
        authors.add(alice);
        authors.add(tom);

        IntSummaryStatistics statistics = authors.stream().collect(Collectors.summarizingInt(Author::getAge));
        System.out.println(statistics);
        System.out.println(statistics.getAverage());


        ArrayList<Developer> developers = new ArrayList<>();
        // by pos
        Map<String,List<Developer>> posMap = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos));

        // qtt by pos
        Map<String,Long> posCount = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.counting()));

        // name by pos
        Map<String, Set<String>> posName = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.mapping(Developer::getName, Collectors.toSet())));

        // avr salary by pos

        Map<String, Double> posAverageSalary = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.averagingDouble(Developer::getSalary)));

        //
        Map<String, Map<Integer,List<Developer>>> posAdmAge = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPos,Collectors.groupingBy(Developer::getAge)));

    }
}

class Article{
    enum Category{
        JAVA, PHP, PYTHON
    }

    public Article(String title, Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Article article = (Article) object;

        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (author != null ? !author.equals(article.author) : article.author != null) return false;
        return category == article.category;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    private  String title;
    private Author author;
    private Category category;

}

class Author{
    String name;
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Author author = (Author) object;

        return name != null ? name.equals(author.name) : author.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }
}

class Developer{
    private String name;
    private int age;
    private int salary;
    private String pos;

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", pos='" + pos + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Developer developer = (Developer) object;

        if (age != developer.age) return false;
        if (salary != developer.salary) return false;
        if (name != null ? !name.equals(developer.name) : developer.name != null) return false;
        return pos != null ? pos.equals(developer.pos) : developer.pos == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Developer(String name, int age, int salary, String pos) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.pos = pos;
    }
}