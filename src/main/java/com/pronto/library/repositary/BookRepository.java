package com.pronto.library.repositary;

import com.pronto.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

/**
 * The interface Book repository.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Find book by author containing or title containing optional.
     *
     * @param author the author
     * @param title  the title
     * @return the optional
     */
    Optional<Collection<Book>> findBookByAuthorContainingOrTitleContaining(final String author, final String title);

    /**
     * Find book by display id optional.
     *
     * @param displayId the display id
     * @return the optional
     */
    Optional<Book> findBookByDisplayId(final String displayId);

}
