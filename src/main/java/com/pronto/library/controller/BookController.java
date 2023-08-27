package com.pronto.library.controller;

import com.pronto.library.dto.input.BookCreateInputData;
import com.pronto.library.dto.response.ResponseBookDto;
import com.pronto.library.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("api/books")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private final BookService bookService;

    @PostMapping("add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseBookDto add(final @Valid @RequestBody BookCreateInputData addBookDto) {
        return bookService.createBook(addBookDto);
    }

    @GetMapping("all")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Collection<ResponseBookDto> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("search")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Collection<ResponseBookDto> search(@RequestParam(name = "title", required = false) @Valid String title,
                                              @RequestParam(name = "author", required = false) @Valid String author) {
        return bookService.searchBooks(title, author);
    }
}
