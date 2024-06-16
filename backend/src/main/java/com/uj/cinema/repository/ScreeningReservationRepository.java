package com.uj.cinema.repository;

import com.uj.cinema.model.entity.ScreeningReservationKey;
import com.uj.cinema.model.entity.ScreeningReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningReservationRepository extends JpaRepository<ScreeningReservation, ScreeningReservationKey> {
}