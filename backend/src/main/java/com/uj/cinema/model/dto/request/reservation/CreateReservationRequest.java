package com.uj.cinema.model.dto.request.reservation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uj.cinema.model.dto.ScreeningReservationDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateReservationRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String screeningId;

    @NotNull
    private List<ScreeningReservationDTO> screeningReservations;
}