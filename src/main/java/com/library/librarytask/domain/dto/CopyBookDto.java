package com.library.librarytask.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.librarytask.domain.Rents;
import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyBookDto {

    private long id;
    private Title title;

    private Status status;

    public CopyBookDto(Title title, Status status) {
        this.title = title;
        this.status = status;
    }
}
