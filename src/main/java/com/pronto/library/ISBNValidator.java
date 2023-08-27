package com.pronto.library;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.logging.log4j.util.Strings;

import java.util.regex.Pattern;

public class ISBNValidator implements ConstraintValidator<ValidISBN, String> {

    @Override
    public void initialize(ValidISBN constraintAnnotation) {
    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext context) {
        if (Strings.isNotEmpty(isbn)) {
            return isValidIsbn10(isbn) || isValidIsbn13(isbn);
        }
        return true;
    }

    private boolean isValidIsbn10(String isbn) {
        String regex = "^(?:\\d{9}[\\d|Xx])|(?:\\d{1,5}-\\d{1,7}-\\d{1,6}-[\\d|Xx])$";
        return Pattern.matches(regex, isbn);
    }

    private boolean isValidIsbn13(String isbn) {
        String regex = "^(?:\\d{12}\\d|[\\d|-]{1,5}-\\d{1,7}-\\d{1,6}-\\d)$";
        return Pattern.matches(regex, isbn);
    }

}
