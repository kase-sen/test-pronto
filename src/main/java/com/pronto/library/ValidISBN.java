package com.pronto.library;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Constraint(validatedBy = {ISBNValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidISBN {
}