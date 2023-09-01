package com.pronto.library.dto.input;

import com.pronto.library.annotation.ValidISBN;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 * The type Book create input data.
 */
public record BookCreateInputData(

        @NotEmpty(message = "Book title cannot be null or Empty")
        String title,

        @NotEmpty(message = "Author cannot be null or Empty")
        String author,

        @ValidISBN(message = "ISBN has to be number value")
        String isbn,

        @NotNull(message = "Category be null or Empty")
        String category) {
}
