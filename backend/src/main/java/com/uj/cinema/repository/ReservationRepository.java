package com.uj.cinema.repository;

import com.uj.cinema.model.entity.Reservation;
import com.uj.cinema.model.exception.reservation.ReservationNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    default Reservation getByGuid(final String guid) {
        return this.findById(guid).orElseThrow(() -> new ReservationNotFoundException("Reservation with id " + guid + " not found"));
    }

}
