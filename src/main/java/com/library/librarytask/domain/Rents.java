package com.library.librarytask.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "RENTS")
public class Rents {

    private Long id;
    private CopyBooks copyBooks;
    private Reader reader;
    private Date rentDate;
    private Date returnDate;


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public CopyBooks getCopyBooks() {
        return copyBooks;
    }

    public void setCopyBooks(CopyBooks copyBooks) {
        this.copyBooks = copyBooks;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @NotNull
    @Column(name = "RENT_DATE")
    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    @NotNull
    @Column(name = "RETURN_DATE")
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
