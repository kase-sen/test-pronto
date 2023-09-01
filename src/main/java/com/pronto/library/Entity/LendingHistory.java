package com.pronto.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * The type Lending history.
 */
@NoArgsConstructor
@Data
@SuperBuilder
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class LendingHistory extends AuditableBaseEntity {

    @Column(nullable = false)
    private OffsetDateTime lendingStartTs;

    @Column
    private OffsetDateTime lendingEndTs;

    @Column
    private BigDecimal lendingPenaltyAmount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "BookId")
    private Book book;

}
