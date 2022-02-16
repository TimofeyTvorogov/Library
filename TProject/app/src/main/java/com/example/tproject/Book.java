package com.example.tproject;

public class Book {
    String BookTitle;
    String BookAuthor;
    int BookYear;
    int BookCover;

    public Book(String BookTitle, String BookAuthor, int BookYear, int BookCover) {
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.BookYear = BookYear;
        this.BookCover = BookCover;
    }

    @Override
    public String toString() {
        return BookAuthor + ": "+ BookTitle;
    }
}
