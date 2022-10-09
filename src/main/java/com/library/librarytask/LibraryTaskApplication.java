package com.library.librarytask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.library.librarytask.*")
public class LibraryTaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibraryTaskApplication.class, args);
    }

}
