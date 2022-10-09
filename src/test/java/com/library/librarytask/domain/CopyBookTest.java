package com.library.librarytask.domain;

import com.library.librarytask.repository.CopyBookRepository;
import com.library.librarytask.repository.StatusRepository;
import com.library.librarytask.repository.TitleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CopyBookTest {

    @Autowired
    private CopyBookRepository copyBookRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Test
    void testAddCopybook(){
        Title title = new Title("Title 1", "Author 1", 2000);
        Status status = new Status("Available");
        CopyBook copybook = new CopyBook(title, status);

        titleRepository.save(title);
        statusRepository.save(status);
        copyBookRepository.save(copybook);
        long idTitle = title.getId();
        long idStatus = status.getId();
        long idCopybook = copybook.getId();

        assertAll(
                () -> assertEquals(1, titleRepository.findAll().size()),
                () -> assertTrue(titleRepository.existsById(idTitle)),
                () -> assertEquals(1, copyBookRepository.findAll().size()),
                () -> assertTrue(copyBookRepository.existsById(idCopybook)),
                () -> assertTrue(statusRepository.existsById(idStatus))
        );

       /* copyBookRepository.deleteById(idCopybook);
        titleRepository.deleteById(idTitle);
        statusRepository.deleteById(idStatus);*/

    }
}