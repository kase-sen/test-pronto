package com.pronto.library.service;

import com.pronto.library.Entity.Book;
import com.pronto.library.Entity.Category;
import com.pronto.library.dto.input.BookCreateInputData;
import com.pronto.library.dto.response.ResponseBookDto;
import com.pronto.library.repositary.BookRepository;
import com.pronto.library.repositary.CategoryRepository;
import execption.ResultNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.stream.Collectors;


/**
 * Holds Book related business functionality operations
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    /**
     *
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseBookDto createBook(final BookCreateInputData bookCreateInputData) {

        final Category category = categoryRepository.findCategoryByName(bookCreateInputData.category())
                .orElseThrow(() ->
                        new ResultNotFoundException(String.format("Not category found for %s ", bookCreateInputData.category())));
        ;

        final Book book = Book.builder().
                author(bookCreateInputData.author()).
                title(bookCreateInputData.title()).
                isbn(bookCreateInputData.isbn()).
                category(category).
                createdTs(OffsetDateTime.now()).
                build();
        final Book savedBook = bookRepository.save(book);

        return new ModelMapper().map(savedBook, ResponseBookDto.class);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Collection<ResponseBookDto> getAllBooks() {
        final Collection<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> new ModelMapper().map(book, ResponseBookDto.class))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Collection<ResponseBookDto> searchBooks(String title, String author) throws ResultNotFoundException {

        final Collection<Book> books = bookRepository.findBookByAuthorContainingOrTitleContaining(author, title).orElseThrow(() ->
                new ResultNotFoundException(String.format("Not books found for author %s and title %s ", author, title)));

        return books.stream()
                .map(book -> new ModelMapper().map(book, ResponseBookDto.class))
                .collect(Collectors.toList());

    }
}
