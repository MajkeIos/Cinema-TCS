package com.uj.cinema.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uj.cinema.model.entity.UserRole;
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
public final class UserDTO {

    @NotBlank
    private String userId;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    @NotNull
    private LocalDateTime registrationDate;

    @NotNull
    private UserRole role;
}
