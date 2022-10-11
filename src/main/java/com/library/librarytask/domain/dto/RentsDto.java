package com.library.librarytask.domain.dto;

import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Reader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentsDto {

    private long id;
    private CopyBook copyBook;
    private Reader reader;
    private LocalDate rentDate;
    private LocalDate returnDate;


    public RentsDto(CopyBook copyBook, Reader reader, LocalDate rentDate, LocalDate returnDate) {
        this.copyBook = copyBook;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public RentsDto(CopyBook copyBook, Reader reader, LocalDate rentDate) {
        this.copyBook = copyBook;
        this.reader = reader;
        this.rentDate = rentDate;
    }
}
