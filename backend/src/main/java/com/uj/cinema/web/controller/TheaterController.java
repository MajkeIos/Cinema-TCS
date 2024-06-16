package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.TheaterDTO;
import com.uj.cinema.model.dto.request.theater.CreateTheaterRequest;
import com.uj.cinema.model.dto.request.theater.UpdateTheaterRequest;
import com.uj.cinema.service.TheaterService;
import java.util.List;
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
@RequestMapping("/v1/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    @GetMapping
    public ResponseEntity<List<TheaterDTO>> getAllTheaters() {
        final List<TheaterDTO> theaters = theaterService.getAllTheaters();
        return new ResponseEntity<>(theaters, HttpStatus.OK);
    }

    @GetMapping("/{theaterId}")
    public ResponseEntity<TheaterDTO> getTheater(@PathVariable final String theaterId) {
        final TheaterDTO theater = theaterService.getTheaterByTheaterId(theaterId);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TheaterDTO> createTheater(@RequestBody final CreateTheaterRequest request) {
        final TheaterDTO theater = theaterService.createTheater(request);
        return new ResponseEntity<>(theater, HttpStatus.CREATED);
    }

    @PatchMapping("/{theaterId}")
    public ResponseEntity<TheaterDTO> updateTheater(@PathVariable final String theaterId, @RequestBody final UpdateTheaterRequest request) {
        final TheaterDTO theater = theaterService.updateTheaterByTheaterId(theaterId, request);
        return new ResponseEntity<>(theater, HttpStatus.OK);
    }

    @DeleteMapping("/{theaterId}")
    public ResponseEntity<Void> deleteTheater(@PathVariable final String theaterId) {
        theaterService.deleteTheater(theaterId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
