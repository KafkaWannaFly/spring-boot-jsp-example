package com.kms.mvcjsp.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
