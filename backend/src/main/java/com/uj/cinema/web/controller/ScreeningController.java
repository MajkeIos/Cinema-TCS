package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.ScreeningDTO;
import com.uj.cinema.model.dto.request.screening.CreateScreeningRequest;
import com.uj.cinema.service.ScreeningService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/screenings")
@CrossOrigin(origins = "http://localhost:3000")
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<List<ScreeningDTO>> getScreenings(@RequestParam(value = "start", required = false) final LocalDateTime start,
                                                            @RequestParam(value = "end", required = false) final LocalDateTime end) {
        final List<ScreeningDTO> screenings = screeningService.getScreenings(start, end);
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    @GetMapping("/{screeningId}")
    public ResponseEntity<ScreeningDTO> getScreening(@PathVariable final String screeningId) {
        final ScreeningDTO screening = screeningService.getScreeningByScreeningId(screeningId);
        return new ResponseEntity<>(screening, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScreeningDTO> createScreening(@RequestBody final CreateScreeningRequest request) {
        final ScreeningDTO screening = screeningService.createScreening(request);
        return new ResponseEntity<>(screening, HttpStatus.CREATED);
    }

    @DeleteMapping("/{screeningId}")
    public ResponseEntity<Void> deleteScreening(@PathVariable final String screeningId) {
        screeningService.deleteScreening(screeningId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
