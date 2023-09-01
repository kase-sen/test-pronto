package com.pronto.library.repositary;

import com.pronto.library.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Category repository.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Find category by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Category> findCategoryByName(final String name);

}
