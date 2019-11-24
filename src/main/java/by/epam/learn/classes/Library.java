package by.epam.learn.classes;

import java.util.Arrays;

public class Library {
    private Book[] books;

    public Library(Book book) {
        books = new Book[]{book};
    }

    public Library(Book[] books) {
        this.books = books.clone();
    }

    public Book[] getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        books = addExemplar(book);
    }

    public void addBooks(Book[] books) {
        for(Book book : books) {
            this.books = addExemplar(book);
        }
    }

    private Book[] addExemplar(Book book) {
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = book;
        return books;
    }

    public void showSpecificAuthor(String author) {
        for(Book book : books) {
            if(book.getAuthor().contains(author)) {
                System.out.println(book);
            }
        }
    }

    public void showSpecificPublisher(String publisher) {
        for(Book book : books) {
            if(book.getPublisher().contains(publisher)) {
                System.out.println("Издательство: " + book.getPublisher()+ "  " + book);
            }
        }
    }

    public void showBooksAfterYear(int year) {
        for(Book book : books) {
            if(book.getYear() > year) {
                System.out.println("Год издания: " + book.getYear()+ "  " + book);
            }
        }
    }
}
