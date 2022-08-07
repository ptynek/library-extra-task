package com.library.librarytask.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
public class Books {

    private Long id;
    private String title;
    private String author;
    private int publicationYear;

    @NotNull
    @GeneratedValue
    @Id
    @Column(name = "Id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @NotNull
    @Column(name = "PUBLICATION_YEAR")
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
