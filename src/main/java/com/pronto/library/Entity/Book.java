package com.pronto.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pronto.library.enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The type Book.
 */
@NoArgsConstructor
@Data
@SuperBuilder
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Book extends AuditableBaseEntity {

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 150, nullable = false)
    private String author;

    @Column(length = 50, nullable = false, unique = true)
    private String isbn;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryId")
    private Category category;

}
