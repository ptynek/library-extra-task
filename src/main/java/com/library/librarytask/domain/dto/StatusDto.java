package com.library.librarytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {

    private long id;
    private String status;

    public StatusDto(String status) {
        this.status = status;
    }
}
