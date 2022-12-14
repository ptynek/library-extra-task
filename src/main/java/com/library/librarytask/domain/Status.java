package com.library.librarytask.domain;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "STATUS")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "STATUS")
    private String status;

    public Status(String status) {
        this.status = status;
    }
}
