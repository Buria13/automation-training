package by.epam.learn.classes;

public class Book {
    private static int countId = 0;
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private double price;
    private String binding;

    public Book(String t, String a) {
        this.id = ++countId;
        title = t;
        author = a;
    }

    public Book(String title, String author, String publisher,
         int year, int pages, double price, String binding) {
        this.id = ++countId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.binding = binding;
    }

    public String toString(){
        return "\"" + getTitle() + "\", автор: " + getAuthor();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }
}
