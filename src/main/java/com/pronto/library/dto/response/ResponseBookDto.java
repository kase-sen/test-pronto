package com.pronto.library.dto.response;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * The type Response book dto.
 */
@Data
public class ResponseBookDto {

    private String displayId;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private OffsetDateTime createdTs;
}
