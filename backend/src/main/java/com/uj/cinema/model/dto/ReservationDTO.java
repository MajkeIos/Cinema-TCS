package com.uj.cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ReservationDTO {

    @NotBlank
    private String reservationId;

    @NotNull
    private UserDTO user;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private List<ScreeningReservationDTO> screeningReservations;
}
