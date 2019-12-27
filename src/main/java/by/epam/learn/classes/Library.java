package by.epam.learn.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(Book book) {
        books.add(book);
    }

    public Library(Book[] books) {
        this.books = new ArrayList<>(Arrays.asList(books));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        books.add(book);
    }

    public void addBooks(Book[] books) {
        Collections.addAll(this.books, books);
    }

    public void showSpecificAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                System.out.println(book);
            }
        }
    }

    public void showSpecificPublisher(String publisher) {
        for (Book book : books) {
            if (book.getPublisher().contains(publisher)) {
                System.out.println("Издательство: " + book.getPublisher()+ "  " + book);
            }
        }
    }

    public void showBooksAfterYear(int year) {
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println("Год издания: " + book.getYear()+ "  " + book);
            }
        }
    }
}
