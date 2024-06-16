package com.uj.cinema.service;

import com.uj.cinema.model.dto.ScreeningReservationDTO;
import com.uj.cinema.model.entity.ScreeningReservation;
import com.uj.cinema.repository.ScreeningReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreeningReservationService {

    private final ScreeningReservationRepository screeningReservationRepository;

    public ScreeningReservationDTO createScreeningReservation(final ScreeningReservation screeningReservation) {
        return screeningReservationRepository.save(screeningReservation).toDTO();
    }
}
