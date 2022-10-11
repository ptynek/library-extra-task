package com.library.librarytask.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.library.librarytask.adapter.LocalDateAdapter;
import com.library.librarytask.domain.dto.ReaderCreateDto;
import com.library.librarytask.domain.dto.ReaderDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
class ReaderControllerTest {

    private static int testCounter = 0;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("Create reader")
    void testCreateUser() throws Exception{
        ReaderCreateDto readerCreateDto = new ReaderCreateDto("Sarah", "Jones");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        String jsonContent = gson.toJson(readerCreateDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/readers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get all readers")
    void testShouldGetAllReaders() throws Exception{

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/readers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    @DisplayName("Get reader with specific id")
    void testShouldGetUserWithSpecificId() throws Exception{
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/readers/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Jan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Nowak")));
    }

    @Test
    @DisplayName("Update reader")
    void testUpdateUser() throws Exception{
        ReaderDto reader = new ReaderDto(1L, "Jan", "Nowak");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(reader);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/v1/readers")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Jan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Nowak")));
    }



}