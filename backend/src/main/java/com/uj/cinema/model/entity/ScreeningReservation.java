package com.uj.cinema.model.entity;

import com.uj.cinema.model.dto.ScreeningReservationDTO;
import com.uj.cinema.model.enumeration.GuidPrefix;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "screening_reservation")
public class ScreeningReservation {

    public static final String GUID_PREFIX = GuidPrefix.SCREENING_RESERVATION.getName();

    @EmbeddedId
    private ScreeningReservationKey screeningReservationId;

    @ManyToOne
    @MapsId("reservationId")
    @JoinColumn(name = "reservation_id")
    @EqualsAndHashCode.Exclude
    private Reservation reservation;

    @ManyToOne
    @MapsId("screeningId")
    @JoinColumn(name = "screening_id")
    @EqualsAndHashCode.Exclude
    private Screening screening;

    @Column(name = "ticket_price", nullable = false)
    private Float ticketPrice;

    @Column(name = "ticket_type", nullable = false)
    private String ticketType;

    public Integer getRowNumber() {
        return screeningReservationId.getRowNumber();
    }

    public void setRowNumber(final Integer rowNumber) {
        screeningReservationId.setRowNumber(rowNumber);
    }

    public Integer getSeatNumber() {
        return screeningReservationId.getSeatNumber();
    }

    public void setSeatNumber(final Integer seatNumber) {
        screeningReservationId.setSeatNumber(seatNumber);
    }

    public ScreeningReservationDTO toDTO() {
        return ScreeningReservationDTO.builder()
                .rowNumber(getRowNumber())
                .seatNumber(getSeatNumber())
                .ticketPrice(getTicketPrice())
                .ticketType(getTicketType())
                .build();
    }
}