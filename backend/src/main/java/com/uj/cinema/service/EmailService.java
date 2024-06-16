package com.uj.cinema.service;

import com.uj.cinema.model.dto.request.email.SendEmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Value("${spring.mail.username}")
    private String mailSenderUsername;
    private final JavaMailSender mailSender;

    public void sendEmail(final SendEmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSenderUsername);
        message.setTo(request.getRecipient());
        message.setText(request.getMessage());
        message.setSubject("Ticket purchase confirmation");
        mailSender.send(message);
    }
}
