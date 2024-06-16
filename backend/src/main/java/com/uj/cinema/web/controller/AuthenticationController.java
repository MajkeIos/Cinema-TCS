package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.request.auth.AuthenticationRequest;
import com.uj.cinema.model.dto.request.auth.RegisterRequest;
import com.uj.cinema.model.dto.response.auth.AuthenticationResponse;
import com.uj.cinema.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody final RegisterRequest request) {
        final AuthenticationResponse authResponse = authService.register(request);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody final AuthenticationRequest request) {
        final AuthenticationResponse authResponse = authService.authenticate(request);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

}
