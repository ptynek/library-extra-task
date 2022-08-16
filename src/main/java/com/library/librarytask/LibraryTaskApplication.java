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

/*
        LocalDate date = LocalDate.now();

        Reader readerDto = new Reader(1, "Jan", "Kowalski", date);
        TitleDto titleDto = new TitleDto(1,"Tytuł 1", "Author 1", 2003);
        TitleMapper titleMapper = new TitleMapper();
        Title title = titleMapper.mapToTile(titleDto);
        String status = new Status().statusList().get(1);
        CopyBookDto copyBookDto = new CopyBookDto(1, title, status);

        int readerDtoId = readerDto.getId();
        String readerDtoName = readerDto.getFirstName();
        String readerDtoLastName = readerDto.getLastName();

        System.out.println("id: " + readerDtoId + "\n" +
                "First name : " + readerDtoName + "\n" +
                "Last name : " + readerDtoLastName + "\n" +
                "Account created: " + readerDto.getAccountCreated().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" +
                "TitleDto id: " + titleDto.getId() + "\n" +
                "Title: " + titleDto.getTitle() + "\n" +
                "Author: " + titleDto.getAuthor() + "\n" +
                "Publication year: " + titleDto.getPublicationYear() + "\n" +
                "Copy book id " + copyBookDto.getId() + "\n" +
                "Coby book title: " + copyBookDto.getTitle().getTitle() + "\n" +
                "copy book status: " + copyBookDto.getStatus() + "\n"
                );

*/



        SpringApplication.run(LibraryTaskApplication.class, args);
    }

}
