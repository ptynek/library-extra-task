package com.library.librarytask;

import com.library.librarytask.domain.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryTaskTestSuite {

    @Test
    void createUserTest(){
        Reader reader = new Reader(1, "Piotr", "Kowalczyk", LocalDate.now());

        int id = reader.getId();

        assertEquals(1, id);
    }
}
