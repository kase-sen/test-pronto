package com.pronto.library.annotation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

/**
 * The interface Valid isbn.
 */
@Constraint(validatedBy = {ISBNValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidISBN {
    /**
     * Message string.
     *
     * @return the string
     */
    String message();
}