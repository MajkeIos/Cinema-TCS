package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.request.email.SendEmailRequest;
import com.uj.cinema.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/email")
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<Void> sendEmail(@RequestBody SendEmailRequest request) {
        emailService.sendEmail(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
