package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "COPYBOOK_ID", unique = true)
    private long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS_ID")
    private Status status;

//    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "copyBookList")
    private List<Rents> rentsList;

    public CopyBook(Title title, Status status) {
        this.title = title;
        this.status = status;
    }
}
