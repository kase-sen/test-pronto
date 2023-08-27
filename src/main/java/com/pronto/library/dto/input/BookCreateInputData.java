package com.pronto.library.dto.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.ISBN;


public record BookCreateInputData(

        @NotEmpty(message = "Book title cannot be null or Empty")
        String title,

        @NotEmpty(message = "Author cannot be null or Empty")
        String author,

        @ISBN(message = "ISBN has to be number value")
        String isbn,

        @NotNull(message = "Category be null or Empty")
        String category) {
}
