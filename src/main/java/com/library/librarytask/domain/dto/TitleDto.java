package com.library.librarytask.domain.dto;


import com.library.librarytask.domain.CopyBook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TitleDto {

    private long id;
    private String title;
    private String author;
    private int publicationYear;

    public TitleDto(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
