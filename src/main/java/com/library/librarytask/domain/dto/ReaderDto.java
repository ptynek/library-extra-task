package com.library.librarytask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ReaderDto {

    private int id;
    private String firstName;
    private String lastName;

}