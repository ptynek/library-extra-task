package com.library.librarytask.controller;

import com.google.gson.Gson;
import com.library.librarytask.domain.Reader;
import com.library.librarytask.domain.dto.ReaderCreateDto;
import com.library.librarytask.domain.dto.ReaderDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ReaderControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void testShouldGetAllUsers() throws Exception{

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/readers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    void testShouldGetUserWithSpecificId() throws Exception{
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/readers/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("John")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Smith")));
    }

    @Test
    void testUpdateUser() throws Exception{
        ReaderDto reader = new ReaderDto(1,"Jan", "Nowak");
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

    @Test
    void testCreateUser() throws Exception{
        ReaderCreateDto readerCreateDto = new ReaderCreateDto(200, "Sarah", "Jones");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(readerCreateDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/readers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}