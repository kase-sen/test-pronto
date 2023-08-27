package com.pronto.library.service;

import com.pronto.library.Entity.Book;
import com.pronto.library.Entity.Category;
import com.pronto.library.Entity.LendingHistory;
import com.pronto.library.dto.response.ResponseLendingDto;
import com.pronto.library.repositary.BookRepository;
import com.pronto.library.repositary.LendingRepository;
import execption.PreConditionFailedException;
import execption.ResultNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;


@Service
@RequiredArgsConstructor
@Slf4j
public class LendingService {

    private final BookRepository bookRepository;
    private final LendingRepository lendingRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseLendingDto lendBook(final String bookDisplayId) {

        if (!StringUtils.hasLength(bookDisplayId)) {
            throw new PreConditionFailedException("Book id has invalid input value");
        }

        final Book book = bookRepository.findBookByDisplayId(bookDisplayId).orElseThrow(() ->
                new ResultNotFoundException(String.format("No book found for ID : %s ", bookDisplayId)));

        final LendingHistory lendingHistory = LendingHistory.builder().
                lendingStartTs(OffsetDateTime.now()).
                book(book).
                createdTs(OffsetDateTime.now()).
                build();

        final LendingHistory savedLendingHistory = lendingRepository.save(lendingHistory);
        return new ModelMapper().map(savedLendingHistory, ResponseLendingDto.class);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseLendingDto returnBook(final String bookDisplayId) {

        if (!StringUtils.hasLength(bookDisplayId)) {
            throw new PreConditionFailedException("Book id has invalid input value");
        }

        final Book book = bookRepository.findBookByDisplayId(bookDisplayId).orElseThrow(() ->
                new ResultNotFoundException(String.format("No book found for ID : %s ", bookDisplayId)));

        final LendingHistory lendingHistory = lendingRepository.findLatestLendingHistory(bookDisplayId).orElseThrow(() ->
                new ResultNotFoundException(String.format("No Lending History found for for Book ID : %s ", bookDisplayId)));

        final Category categoryData = book.getCategory();

        final OffsetDateTime lendingPeriodMaxDateTime = lendingHistory.getCreatedTs().plusDays(categoryData.getLendingPeriod());
        final OffsetDateTime currentDateTime = OffsetDateTime.now();

        //Calculate
        BigDecimal penaltyAmount = new BigDecimal(0.00);
        if (currentDateTime.isAfter(lendingPeriodMaxDateTime)) {
            long numOfPenaltyDays = Duration.between(lendingPeriodMaxDateTime, currentDateTime).toDays();
            penaltyAmount = new BigDecimal(numOfPenaltyDays * categoryData.getLendingPenalty().longValue());
        }

        lendingHistory.setLendingPenaltyAmount(penaltyAmount);
        lendingHistory.setLendingEndTs(OffsetDateTime.now());

        lendingRepository.save(lendingHistory);
        return new ModelMapper().map(lendingHistory, ResponseLendingDto.class);
    }


}
