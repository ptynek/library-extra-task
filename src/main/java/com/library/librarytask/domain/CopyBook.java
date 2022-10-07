package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "COPYBOOK")
public class CopyBook {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COPYBOOK_ID", unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "copyBookList")
    private List<Rents> rentsList;

    public CopyBook(long id, Title title, Status status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }
}
