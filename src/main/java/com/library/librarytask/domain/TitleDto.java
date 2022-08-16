package com.library.librarytask.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TitleDto {

    private int id;
    private String title;
    private String author;
    private int publicationYear;

}
