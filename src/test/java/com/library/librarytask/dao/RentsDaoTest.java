package com.library.librarytask.dao;

import com.library.librarytask.domain.Books;
import com.library.librarytask.domain.CopyBooks;
import com.library.librarytask.domain.Reader;
import com.library.librarytask.domain.Rents;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Copy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentsDaoTest {
    @Autowired
    private RentsDao rentsDao;

    @Test
    void testRentsDaoSave(){
        Reader reader = new Reader("Piotr", "Kowalczyk", LocalDate.of(2022,1,11));
        Books books = new Books("Tytuł 1", "Autor 1", 2022);
        CopyBooks copyBooks = new CopyBooks(1L, books, "Wypożyczone");
        Rents rents = new Rents(copyBooks, reader);

        System.out.println(rents.getReader());

        rentsDao.save(rents);

        int id = rents.getId();

        assertEquals(0, id);

        rentsDao.deleteById(id);


    }

}