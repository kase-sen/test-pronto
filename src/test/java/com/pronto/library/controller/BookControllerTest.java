package com.pronto.library.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pronto.library.dto.input.BookCreateInputData;
import com.pronto.library.service.BookService;
import config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
@Import(SecurityConfig.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    BookService bookService;


    @Test
    public void createBookSuccessTestAPI() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/api/books/add")
                        .content(asJsonString(new BookCreateInputData(" title", "author", "9781234567897", "CD")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}