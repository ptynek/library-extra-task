package com.library.librarytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReaderCreateDto {

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate accountCreated;

    public ReaderCreateDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = LocalDate.now();
    }
}
