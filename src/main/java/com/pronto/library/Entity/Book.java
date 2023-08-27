package com.pronto.library.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
