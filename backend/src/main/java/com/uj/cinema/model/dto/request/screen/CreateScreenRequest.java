package com.uj.cinema.model.dto.request.screen;

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
public class CreateScreenRequest {

    @NotBlank
    private String theaterId;

    @NotBlank
    private String name;

    @NotNull
    private Integer numberOfRows;

    @NotNull
    private Integer numberOfColumns;
}
