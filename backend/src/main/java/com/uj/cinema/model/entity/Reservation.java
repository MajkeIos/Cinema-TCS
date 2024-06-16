package com.uj.cinema.model.entity;

import com.uj.cinema.model.dto.ReservationDTO;
import com.uj.cinema.model.enumeration.GuidPrefix;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    public static final String GUID_PREFIX = GuidPrefix.RESERVATION.getName();

    @Id
    @Column(name = "id")
    private String reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "reservation")
    private Set<ScreeningReservation> screeningReservations;

    public ReservationDTO toDTO() {
        return ReservationDTO.builder()
                .reservationId(getReservationId())
                .user(getUser().toDTO())
                .timestamp(getTimestamp())
                .screeningReservations(getScreeningReservations()
                        .stream()
                        .map(ScreeningReservation::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }

}