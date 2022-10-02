package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "TITLE")
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private int id;

    @NotNull
    @Column(name = "TITLE")
    private String title;

    @NotNull
    @Column(name = "AUTHOR")
    private String author;

    @NotNull
    @Column(name = "PUBLICATION_YEAR")
    private int publicationYear;

    @JsonIgnore
    @OneToMany(
            targetEntity = CopyBook.class,
            mappedBy = "status",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<CopyBook> copyBooksList;



}
