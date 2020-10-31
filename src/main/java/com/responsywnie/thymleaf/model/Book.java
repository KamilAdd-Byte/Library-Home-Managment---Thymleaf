package com.responsywnie.thymleaf.model;

import javax.persistence.*;
import javax.swing.*;
import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title",nullable = true,unique = true)
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "description")
    private String description;
    @Column(name = "localization")
    private int localization;

    public Book(String title, String author, String isbn, String description, int localization) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.localization = localization;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDespription() {
        return description;
    }

    public void setDespription(String despription) {
        this.description = despription;
    }

    public int getLocalization() {
        return localization;
    }

    public void setLocalization(int localization) {
        this.localization = localization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                localization == book.localization &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                isbn.equals(book.isbn) &&
                description.equals(book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isbn, description, localization);
    }
}
