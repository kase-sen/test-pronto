package com.pronto.library;

import com.pronto.library.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LibraryApplicationTests {

    @Autowired
    BookController bookController;

    @Test
    void contextLoads() {
    }

}
