package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Reader;
import lombok.Getter;

import java.util.Date;

@Getter
public class RentsDto {

    private int id;
    private CopyBook copyBook;
    private Reader reader;
    private Date rentDate;
    private Date returnDate;


    public RentsDto(CopyBook copyBook, Reader reader) {
        this.copyBook = copyBook;
        this.reader = reader;
        this.rentDate = new Date();
    }
}
