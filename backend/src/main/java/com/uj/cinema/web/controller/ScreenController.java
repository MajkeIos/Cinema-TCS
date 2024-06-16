package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.ScreenDTO;
import com.uj.cinema.model.dto.request.screen.CreateScreenRequest;
import com.uj.cinema.model.dto.request.screen.UpdateScreenRequest;
import com.uj.cinema.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/screens")
public class ScreenController {

    private final ScreenService screenService;

    @GetMapping("/{screenId}")
    public ResponseEntity<ScreenDTO> getScreen(@PathVariable final String screenId) {
        final ScreenDTO screen = screenService.getScreenByScreenId(screenId);
        return new ResponseEntity<>(screen, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScreenDTO> createScreen(@RequestBody final CreateScreenRequest request) {
        final ScreenDTO screen = screenService.createScreen(request);
        return new ResponseEntity<>(screen, HttpStatus.CREATED);
    }

    @PatchMapping("/{screenId}")
    public ResponseEntity<ScreenDTO> updateScreen(@PathVariable final String screenId, @RequestBody final UpdateScreenRequest request) {
        final ScreenDTO screen = screenService.updateScreenByScreenId(screenId, request);
        return new ResponseEntity<>(screen, HttpStatus.OK);
    }

    @DeleteMapping("/{screenId}")
    public ResponseEntity<Void> deleteScreen(@PathVariable final String screenId) {
        screenService.deleteScreen(screenId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
