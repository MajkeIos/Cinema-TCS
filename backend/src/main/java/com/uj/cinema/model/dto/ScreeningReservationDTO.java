package com.uj.cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ScreeningReservationDTO {

    @NotNull
    private Integer rowNumber;

    @NotNull
    private Integer seatNumber;

    @NotNull
    private Float ticketPrice;

    @NotBlank
    private String ticketType;
}
