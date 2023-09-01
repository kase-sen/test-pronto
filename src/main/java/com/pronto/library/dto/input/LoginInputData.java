package com.pronto.library.dto.input;

import jakarta.validation.constraints.NotEmpty;


/**
 * The type Login input data.
 */
public record LoginInputData(
        @NotEmpty(message = "User Name cannot be null or Empty")
        String userName,
        @NotEmpty(message = "password cannot be null or Empty")
        String password
) {
}