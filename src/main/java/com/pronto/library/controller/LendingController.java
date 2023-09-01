package com.pronto.library.controller;

import com.pronto.library.dto.input.LendingInputData;
import com.pronto.library.dto.response.ResponseLendingDto;
import com.pronto.library.service.LendingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The type Lending controller.
 */
@RestController
@RequestMapping("api/lend")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LendingController {

    private final LendingService lendingService;

    /**
     * Request to lead book response entity.
     *
     * @param lendingInputData the lending input data
     * @return the response entity
     */
    @PostMapping("start")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<ResponseLendingDto> requestToLeadBook(final @Valid @RequestBody LendingInputData lendingInputData) {

        final String bookDisplayId = lendingInputData.bookId().trim();
        final ResponseLendingDto responseBookDto = lendingService.lendBook(bookDisplayId);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBookDto);
    }

    /**
     * Lead book response lending dto.
     *
     * @param lendingInputData the lending input data
     * @return the response lending dto
     */
    @PostMapping("return")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseLendingDto LeadBook(final @Valid @RequestBody LendingInputData lendingInputData) {

        final String bookDisplayId = lendingInputData.bookId().trim();
        return lendingService.returnBook(bookDisplayId);
    }

}
