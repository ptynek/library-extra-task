package com.library.librarytask.domain;

import com.library.librarytask.helpers.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopyBookDto {

    private int id;
    private Title title;
    private String status;
}
