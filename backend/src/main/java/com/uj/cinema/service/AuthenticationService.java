package com.uj.cinema.service;

import com.uj.cinema.config.jwt.JwtService;
import com.uj.cinema.model.dto.request.auth.AuthenticationRequest;
import com.uj.cinema.model.dto.request.auth.RegisterRequest;
import com.uj.cinema.model.dto.response.auth.AuthenticationResponse;
import com.uj.cinema.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(final RegisterRequest request) {
        final User user = userService.registerUser(request);
        final String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(final AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        final User user = userService.getUserByUsername(request.getUsername());
        final String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
