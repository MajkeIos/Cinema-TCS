package com.uj.cinema.web.controller;

import com.uj.cinema.model.dto.MovieDTO;
import com.uj.cinema.model.dto.request.movie.CreateMovieRequest;
import com.uj.cinema.model.dto.request.movie.UpdateMovieRequest;
import com.uj.cinema.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        final List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable final String movieId) {
        final MovieDTO movie = movieService.getMovieByMovieId(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@RequestBody final CreateMovieRequest request) {
        final MovieDTO movie = movieService.createMovie(request);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PatchMapping("/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable final String movieId, @RequestBody final UpdateMovieRequest request) {
        final MovieDTO movie = movieService.updateMovieByMovieId(movieId, request);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable final String movieId) {
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
