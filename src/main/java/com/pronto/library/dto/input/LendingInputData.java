package com.pronto.library.dto.input;

import jakarta.validation.constraints.NotEmpty;

public record LendingInputData(

        @NotEmpty(message = "book Id cannot be null or Empty")
        String bookId) {

}

