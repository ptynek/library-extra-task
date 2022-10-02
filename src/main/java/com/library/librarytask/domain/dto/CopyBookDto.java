package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.Rents;
import com.library.librarytask.domain.Title;
import com.library.librarytask.helpers.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CopyBookDto {

    private long id;
    private Title title;
    private Status status;
    private List<Rents> rentsList;
}
