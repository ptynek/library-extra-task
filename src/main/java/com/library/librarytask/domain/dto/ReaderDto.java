package com.library.librarytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReaderDto {

    private long id;
    private String firstName;
    private String lastName;


    public ReaderDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
