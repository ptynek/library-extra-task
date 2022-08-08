package com.library.librarytask.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "READER")
public final class Reader {

    private Long id;
    private String firstName;
    private String lastName;

    private LocalDate accountCreated;
    private Rents rents;

    public Reader(){

    }

    public Reader(String firstName, String lastName, LocalDate accountCreated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCreated = accountCreated;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Column(name = "ACCOUNT_CREATED")
    public LocalDate getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(LocalDate accountCreated) {
        this.accountCreated = accountCreated;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RENTS_ID")
    public Rents getRents() {
        return rents;
    }

    public void setRents(Rents rents) {
        this.rents = rents;
    }
}
