package com.library.librarytask.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.Status;
import com.library.librarytask.domain.Title;
import com.library.librarytask.domain.dto.CopyBookDto;
import com.library.librarytask.mapper.TitleMapper;
import com.library.librarytask.serivce.StatusDbService;
import com.library.librarytask.serivce.TitleDbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CopyBookControllerTest {

    private static int testCounter = 0;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TitleDbService titleDbService;
    @Autowired
    private StatusDbService service;
    @Autowired
    private CopyBookController copyBookController;
    @Autowired
    private TitleMapper titleMapper;


    @BeforeEach
    void beforeEach(){
        testCounter ++;
        System.out.println("Test #: " + testCounter);
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Preparing to start Reader Controller tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests are finished");
    }

    @Test
    @DisplayName("Add copybook")
    void testAddCopybook() throws Exception{
        CopyBookDto copyBookDto = new CopyBookDto();
        List<Long> copybook = List.of(1L);
        service.updateStatus(service.getStatus(4), copybook);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(copyBookDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/copybooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}