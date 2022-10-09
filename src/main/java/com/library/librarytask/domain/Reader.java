package com.library.librarytask.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "READER")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @JsonIgnore
    @Column(name = "ACCOUNT_CREATED")
    private LocalDate accountCreated;

    public Reader(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = LocalDate.now();
    }

    public Reader(String firstName, String lastName, LocalDate accountCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = accountCreated;
    }

    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = LocalDate.now();
    }
}
