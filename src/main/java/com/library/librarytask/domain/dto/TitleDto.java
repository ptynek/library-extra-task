package com.library.librarytask.domain.dto;


import com.library.librarytask.domain.CopyBook;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TitleDto {

    private long id;
    private String title;
    private String author;
    private int publicationYear;

}
