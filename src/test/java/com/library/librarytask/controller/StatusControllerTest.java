package com.library.librarytask.controller;

import com.google.gson.Gson;
import com.library.librarytask.domain.CopyBook;
import com.library.librarytask.domain.dto.StatusDto;
import com.library.librarytask.serivce.CopyBookDbService;
import com.library.librarytask.serivce.StatusDbService;
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

@SpringBootTest
@AutoConfigureMockMvc
class StatusControllerTest {

    private static int testCounter = 0;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CopyBookDbService copyBookDbService;
    @Autowired
    private StatusDbService statusDbService;

    @BeforeEach
    void beforeEach(){
        testCounter ++;
        System.out.println("Test #: " + testCounter);
    }
    @BeforeAll
    static void beforeAll(){
        System.out.println("Preparing to start Status Controller tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests are finished");
    }

    @Test
    @DisplayName("Add status")
    void testAddStatus() throws Exception{
        StatusDto statusDto = new StatusDto("Test Status");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(statusDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get all statuses")
    void testGetAllStatuses() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/status")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)));
    }

    @Test
    @DisplayName("Get status with specific ID")
    void testGetStatusWithSpecificId() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/status/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is("Available")));
    }
    @Test
    @DisplayName("Update status in copybook")
    void testUpdateStatusInCopybook() throws Exception{
        CopyBook copyBook = copyBookDbService.getCopyBookById(22L);
        List<Long> list = List.of(copyBook.getId());
        statusDbService.updateStatus(statusDbService.getStatus(1), list);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/copybooks/22")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status.id", Matchers.is(1)));
    }

}