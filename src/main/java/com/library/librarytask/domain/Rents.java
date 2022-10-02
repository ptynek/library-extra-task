package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "RENTS")
public class Rents {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private long id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "JOIN_COPYBOOKS_ID",
            joinColumns = {@JoinColumn(name ="ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "COPYBOOK_ID", referencedColumnName = "COPYBOOK_ID")}
    )
    private List<CopyBook> copyBookList;

    @OneToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    @NotNull
    @Column(name = "RENT_DATE")
    private Date rentDate;

    @Column(name = "RETURN_DATE")
    private Date returnDate;


}
