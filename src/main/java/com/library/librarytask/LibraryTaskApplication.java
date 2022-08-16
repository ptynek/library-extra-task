package com.library.librarytask;

import com.library.librarytask.domain.*;
import com.library.librarytask.helpers.Status;
import com.library.librarytask.mapper.TitleMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class LibraryTaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibraryTaskApplication.class, args);
    }

}
