package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "RENTS")
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RENTS_ID", unique = true)
    private long id;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "COPYBOOK_ID")
    private CopyBook copybook;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @NotNull
    @Column(name = "RENT_DATE")
    private LocalDate rentDate;

    @Column(name = "RETURN_DATE")
    private LocalDate returnDate;

    public Rents(long id, Reader reader, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public Rents(CopyBook copybook, Reader reader, LocalDate rentDate, LocalDate returnDate) {
        this.copybook = copybook;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
