package com.library.librarytask.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Title {

    private int id;
    private String title;
    private String author;
    private int publicationYear;

}
