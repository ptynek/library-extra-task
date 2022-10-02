package com.library.librarytask.helpers;


import com.library.librarytask.domain.CopyBook;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "STATUS")
public class Status {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "STATUS")
    private String status;

    public Status(int id) {
        this.id = id;
        this.status = status;
    }
}
