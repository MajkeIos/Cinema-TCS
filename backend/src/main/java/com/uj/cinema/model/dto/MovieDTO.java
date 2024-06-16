package com.uj.cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class MovieDTO {

    @NotBlank
    private String movieId;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Integer duration;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private String rating;
}
