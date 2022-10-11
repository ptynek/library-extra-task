package com.library.librarytask.controller;

import com.google.gson.Gson;
import com.library.librarytask.domain.dto.TitleDto;
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
class TitleControllerTest {

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
    @DisplayName("Add title")
    void testAddTitle() throws Exception{
        TitleDto titleDto = new TitleDto("Title 1", "Author 1", 2020);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(titleDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/titles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get all titles")
    void testShouldGetAllTitles() throws Exception{
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/titles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @DisplayName("Get title with specific id")
    void testGetTitleWithSpecificId() throws Exception{
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/titles/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Title 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", Matchers.is("Author 1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear", Matchers.is(2020)));
    }

    @Test
    @DisplayName("Update title")
    void testUpdateTitle() throws Exception{
        TitleDto updatedTitle = new TitleDto(1, "Updated Title", "Updated Author", 2021);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(updatedTitle);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/titles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Updated Title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", Matchers.is("Updated Author")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.publicationYear", Matchers.is(2021)));
    }
}