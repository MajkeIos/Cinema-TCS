package com.uj.cinema.model.dto.request.screening;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateScreeningRequest {

    @NotBlank
    private String movieId;

    @NotBlank
    private String screenId;

    @NotNull
    private LocalDateTime timestamp;
}
