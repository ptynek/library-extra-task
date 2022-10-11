package com.library.librarytask.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.library.librarytask.adapter.LocalDateAdapter;
import com.library.librarytask.domain.dto.ReaderDto;
import com.library.librarytask.domain.dto.RentsDto;
import com.library.librarytask.serivce.CopyBookDbService;
import com.library.librarytask.serivce.ReaderDbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class RentsControllerTest {

    private static int testCounter = 0;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CopyBookDbService copyBookDbService;
    @Autowired
    private ReaderDbService readerDbService;

    @BeforeEach
    void beforeEach(){
        testCounter ++;
        System.out.println("Test #: " + testCounter);
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Preparing to start Rents Controller tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests are finished");
    }

    @Test
    @DisplayName("Create rent position")
    void testCreateRent() throws Exception{
        RentsDto rentsDto = new RentsDto(
                copyBookDbService.getCopyBookById(22L),
                readerDbService.getReader(1L),
                LocalDate.now().minusDays(10)
        );
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        String jsonContent = gson.toJson(rentsDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/rents")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @DisplayName("Get all rents")
    void testGetAllRents() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/rents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @DisplayName("Get rent with specific ID")
    void testGetRentWithSpecificId() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/rents/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rentDate", Matchers.is("2022-10-01")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.returnDate", Matchers.nullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.copyBook.id", Matchers.is(22)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.reader.id", Matchers.is(1)));
    }


}