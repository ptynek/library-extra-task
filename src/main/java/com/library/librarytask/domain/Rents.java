package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToMany
    @JoinTable(
            name = "JOIN_COPYBOOKS_ID",
            joinColumns = {@JoinColumn(name ="RENTS_ID", referencedColumnName = "RENTS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COPYBOOK_ID", referencedColumnName = "COPYBOOK_ID")}
    )
    private List<CopyBook> copyBookList;

    @OneToOne
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

    public Rents(List<CopyBook> copyBookList, Reader reader, LocalDate rentDate, LocalDate returnDate) {
        this.copyBookList = copyBookList;
        this.reader = reader;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }
}
