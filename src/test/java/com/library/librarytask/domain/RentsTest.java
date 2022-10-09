package com.library.librarytask.domain;

import com.library.librarytask.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentsTest {

    @Autowired
    private RentsRepository rentsRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private CopyBookRepository copyBookRepository;
    @Autowired
    private StatusRepository statusRepository;



    @Test
    void testAddRent(){
        Title title = new Title("Title 1", "Author 1", 2000);
        Status status = new Status("Available");
        CopyBook copybook = new CopyBook(title, status);
        Reader reader = new Reader("John", "Smith", LocalDate.now().minusDays(7));
        Rents rents = new Rents(copybook, reader, LocalDate.now(), null);

        readerRepository.save(reader);
        titleRepository.save(title);
        statusRepository.save(status);
        copyBookRepository.save(copybook);
        rentsRepository.save(rents);

        long titleId = title.getId();
        long statusId = status.getId();
        long copybookId = copybook.getId();
        long readerId = reader.getId();
        long rentId = rents.getId();

        assertEquals(1, rentsRepository.findAll().size());
/*
        rentsRepository.deleteById(rentId);
        readerRepository.deleteById(readerId);
        copyBookRepository.deleteById(copybookId);
        titleRepository.deleteById(titleId);
        statusRepository.deleteById(statusId);*/
    }
}