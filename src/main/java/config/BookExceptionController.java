package config;

import execption.ResultNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Book exception controller.
 */
@ControllerAdvice
@Slf4j
public class BookExceptionController {

    /**
     * Handle validation exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error(ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.PRECONDITION_FAILED);
    }

    /**
     * Handle result not found exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity handleResultNotFoundExceptions(ResultNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

    /**
     * Handle exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleExceptions(ResultNotFoundException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>("Internal server error please contact support", HttpStatus.CONFLICT);
    }
}