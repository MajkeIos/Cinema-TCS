package com.uj.cinema.repository;

import com.uj.cinema.model.entity.Screening;
import com.uj.cinema.model.exception.screening.ScreeningNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, String> {

    default Screening getByGuid(final String guid) {
        return this.findById(guid).orElseThrow(() -> new ScreeningNotFoundException("Screening with id " + guid + " not found"));
    }

    List<Screening> findByTimestampBetween(final LocalDateTime start, final LocalDateTime end);


}
