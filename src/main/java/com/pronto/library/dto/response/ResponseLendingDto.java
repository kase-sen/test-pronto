package com.pronto.library.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class ResponseLendingDto {

    private String displayId;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private BigDecimal lendingPeriod;
    private BigDecimal lendingPenalty;
    private OffsetDateTime createdTs;
}
