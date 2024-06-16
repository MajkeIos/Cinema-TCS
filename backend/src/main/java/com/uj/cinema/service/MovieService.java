package com.uj.cinema.service;

import com.uj.cinema.model.dto.MovieDTO;
import com.uj.cinema.model.dto.request.movie.CreateMovieRequest;
import com.uj.cinema.model.dto.request.movie.UpdateMovieRequest;
import com.uj.cinema.model.entity.Movie;
import com.uj.cinema.repository.MovieRepository;
import com.uj.cinema.utils.GuidGenerator;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(Movie::toDTO).toList();
    }

    protected Movie getMovieEntityByMovieId(final String movieId) {
        return movieRepository.getByGuid(movieId);
    }

    public MovieDTO getMovieByMovieId(final String movieId) {
        return getMovieEntityByMovieId(movieId).toDTO();
    }

    public MovieDTO createMovie(final CreateMovieRequest request) {
        final Movie movie = Movie.builder()
                .movieId(generateGuid())
                .title(request.getTitle())
                .description(request.getDescription())
                .duration(request.getDuration())
                .releaseDate(request.getReleaseDate())
                .rating(request.getRating())
                .screenings(new HashSet<>())
                .build();
        return movieRepository.save(movie).toDTO();
    }

    public MovieDTO updateMovieByMovieId(final String movieId, final UpdateMovieRequest request) {
        final Movie movie = movieRepository.getByGuid(movieId);

        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setDuration(request.getDuration());
        movie.setReleaseDate(request.getReleaseDate());
        movie.setRating(request.getRating());

        return movieRepository.save(movie).toDTO();
    }

    public void deleteMovie(final String movieId) {
        final Movie movie = movieRepository.getByGuid(movieId);
        movieRepository.delete(movie);
    }

    private String generateGuid() {
        return GuidGenerator.generateGuid(Movie.GUID_PREFIX, movieRepository::existsById);
    }

}
