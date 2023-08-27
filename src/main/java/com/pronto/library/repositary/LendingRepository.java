package com.pronto.library.repositary;

import com.pronto.library.Entity.LendingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LendingRepository extends JpaRepository<LendingHistory, Long> {


    @Query(value = "select h.* from lending_history h join book b on b.id = h.book_id " +
            "where b.display_id= :displayId and h.lending_end_ts is null order by h.id desc", nativeQuery = true)
    Optional<LendingHistory> findLatestLendingHistory(String displayId);

}
