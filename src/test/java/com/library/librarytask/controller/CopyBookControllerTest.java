package com.library.librarytask.controller;

import com.google.gson.Gson;
import com.library.librarytask.domain.dto.CopyBookDto;
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




    @BeforeEach
    void beforeEach(){
        testCounter ++;
        System.out.println("Test #: " + testCounter);
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Preparing to start Copybook Controller tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests are finished");
    }



    @Test
    @DisplayName("Add copybook")
    void testAddCopybook() throws Exception{
        CopyBookDto copyBookDto = new CopyBookDto(titleDbService.getTitle(1), service.getStatus(4));
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

    @Test
    @DisplayName("Get copybook with specific ID")
    void testGetCopybook() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/copybooks/22")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(22)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status.id", Matchers.is(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title.id", Matchers.is(1)));
    }

    @Test
    @DisplayName("Get all copybooks")
    void testGetAllCopybooks() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/copybooks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

}