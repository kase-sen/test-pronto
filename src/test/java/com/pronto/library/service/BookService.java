package com.pronto.library.service;

import com.pronto.library.dto.response.ResponseBookDto;
import com.pronto.library.entity.Book;
import com.pronto.library.repositary.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The type Book service test.
 */
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    /**
     * Gets all books success.
     */
    @Test
    void getAllBooksSuccessTest() {
        final Book book = Book.builder()
                .author("abc book")
                .displayId("237833aa-48a3-11ee-be56-0242ac120002")
                .build();

        Mockito.when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));
        Collection<ResponseBookDto> responseBookDtos = bookService.getAllBooks();
        assertFalse(responseBookDtos.isEmpty());
    }

    /**
     * Gets all books no results.
     */
    @Test
    void getAllBooksNoResultsTest() {
        Mockito.when(bookRepository.findAll()).thenReturn(Collections.emptyList());
        Collection<ResponseBookDto> responseBookDtos = bookService.getAllBooks();
        assertTrue(responseBookDtos.isEmpty());
    }
}