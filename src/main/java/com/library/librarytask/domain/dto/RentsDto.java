package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Reader;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class RentsDto {

    private long id;
    private CopyBook copyBook;
    private Reader reader;
    private LocalDate rentDate;
    private LocalDate returnDate;


    public RentsDto(CopyBook copyBook, Reader reader) {
        this.copyBook = copyBook;
        this.reader = reader;
        this.rentDate = LocalDate.now();
    }

    public RentsDto(long id, Reader reader, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
