package com.library.librarytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ReaderCreateDto {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate accountCreated;

    public ReaderCreateDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = LocalDate.now();
    }
}
