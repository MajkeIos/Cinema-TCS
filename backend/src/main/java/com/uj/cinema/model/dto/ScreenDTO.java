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
public final class ScreenDTO {

    @NotBlank
    private String screenId;

    @NotNull
    private TheaterDTO theater;

    @NotBlank
    private String name;

    @NotNull
    private Integer numberOfRows;

    @NotNull
    private Integer numberOfColumns;
}
