package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.UserDTO;
import com.uj.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable final String username) {
        final UserDTO user = userService.getUserByUsername(username).toDTO();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
