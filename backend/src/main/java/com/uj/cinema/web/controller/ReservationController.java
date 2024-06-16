package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.ReservationDTO;
import com.uj.cinema.model.dto.ScreeningReservationDTO;
import com.uj.cinema.model.dto.request.reservation.CreateReservationRequest;
import com.uj.cinema.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reservations")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservation(@PathVariable final String reservationId) {
        final ReservationDTO reservation = reservationService.getReservationByReservationId(reservationId);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody final CreateReservationRequest request) {
        System.out.println(request.getUsername());
        System.out.println(request.getScreeningId());
        List<ScreeningReservationDTO> screeningReservations = request.getScreeningReservations();
        for(ScreeningReservationDTO reservation: screeningReservations){
            System.out.println("Row Number: " + reservation.getRowNumber());
            System.out.println("Seat Number: " + reservation.getSeatNumber());
            System.out.println("Ticket Price: " + reservation.getTicketPrice());
            System.out.println("Ticket Type: " + reservation.getTicketType());
            System.out.println("---------------------------");
        }
        System.out.println("JAZDA1");
        final ReservationDTO reservation = reservationService.createReservation(request);
        System.out.println("JAZDA1");
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable final String reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
