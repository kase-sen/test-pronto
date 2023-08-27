package com.pronto.library.repositary;

import com.pronto.library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Collection<Book>> findBookByAuthorContainingOrTitleContaining(final String author, final String title);

    Optional<Book> findBookByDisplayId(final String displayId);

}
