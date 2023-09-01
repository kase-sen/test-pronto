package com.pronto.library.enums;

import com.pronto.library.entity.AuditableBaseEntity;
import com.pronto.library.entity.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Category.
 */
@Entity
@Data
@NoArgsConstructor
@SuperBuilder
public class Category extends AuditableBaseEntity {

    @Column
    private String name;

    @Column
    private int lendingPeriod;

    @Column
    private BigDecimal lendingPenalty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;

}