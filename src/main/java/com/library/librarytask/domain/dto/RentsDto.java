package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Reader;
import lombok.Getter;

import java.util.Date;

@Getter
public class RentsDto {

    private long id;
    private CopyBook copyBook;
    private Reader reader;
    private Date rentDate;
    private Date returnDate;


    public RentsDto(CopyBook copyBook, Reader reader) {
        this.copyBook = copyBook;
        this.reader = reader;
        this.rentDate = new Date();
    }

    public RentsDto(long id, Reader reader, Date rentDate, Date returnDate) {
        this.id = id;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
