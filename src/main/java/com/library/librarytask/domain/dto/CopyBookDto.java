package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
