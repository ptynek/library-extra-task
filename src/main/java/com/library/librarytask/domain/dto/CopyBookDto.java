package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.Rents;
import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CopyBookDto {

    private long id;
    private Title title;
    private Status status;
    private List<Rents> rentsList;
}
