package com.uj.cinema.service;

import com.uj.cinema.model.dto.ReservationDTO;
import com.uj.cinema.model.dto.request.reservation.CreateReservationRequest;
import com.uj.cinema.model.entity.Reservation;
import com.uj.cinema.model.entity.ScreeningReservation;
import com.uj.cinema.model.entity.ScreeningReservationKey;
import com.uj.cinema.repository.ReservationRepository;
import com.uj.cinema.utils.GuidGenerator;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final ScreeningService screeningService;
    private final ScreeningReservationService screeningReservationService;

    public ReservationDTO getReservationByReservationId(final String reservationId) {
        return reservationRepository.getByGuid(reservationId).toDTO();
    }

    public ReservationDTO createReservation(final CreateReservationRequest request) {
        final String reservationId = generateGuid();
        final Reservation reservation = Reservation.builder()
                .reservationId(reservationId)
                .user(userService.getUserByUsername(request.getUsername()))
                .timestamp(Instant
                        .ofEpochMilli(System.currentTimeMillis())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime())
                .screeningReservations(new HashSet<>())
                .build();
        reservationRepository.save(reservation);
        request.getScreeningReservations()
                .forEach(screeningReservationDTO -> {
                            ScreeningReservation screeningReservation = ScreeningReservation.builder()
                                    .screeningReservationId(ScreeningReservationKey.builder()
                                            .reservationId(reservationId)
                                            .screeningId(request.getScreeningId())
                                            .rowNumber(screeningReservationDTO.getRowNumber())
                                            .seatNumber(screeningReservationDTO.getSeatNumber())
                                            .build())
                                    .reservation(reservation)
                                    .screening(screeningService.getScreeningEntityByScreeningId(request.getScreeningId()))
                                    .ticketPrice(screeningReservationDTO.getTicketPrice())
                                    .ticketType(screeningReservationDTO.getTicketType())
                                    .build();
                            screeningReservationService.createScreeningReservation(screeningReservation);
                            reservation.getScreeningReservations().add(screeningReservation);
                        }
                );
        return reservationRepository.save(reservation).toDTO();
    }

    public void deleteReservation(final String reservationId) {
        final Reservation reservation = reservationRepository.getByGuid(reservationId);
        reservationRepository.delete(reservation);
    }

    private String generateGuid() {
        return GuidGenerator.generateGuid(Reservation.GUID_PREFIX, reservationRepository::existsById);
    }

}
