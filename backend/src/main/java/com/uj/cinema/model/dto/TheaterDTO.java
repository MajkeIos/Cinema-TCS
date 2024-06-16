package com.uj.cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class TheaterDTO {

    @NotBlank
    private String theaterId;

    @NotBlank
    private String name;

    @NotBlank
    private String location;
}
