package com.uj.cinema.model.dto.request.email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendEmailRequest {

    @NotBlank
    private String message;

    @NotBlank
    private String recipient;
}
