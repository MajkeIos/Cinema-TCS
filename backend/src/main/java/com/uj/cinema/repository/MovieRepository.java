package com.uj.cinema.repository;

import com.uj.cinema.model.entity.Movie;
import com.uj.cinema.model.exception.movie.MovieNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    default Movie getByGuid(final String guid) {
        return this.findById(guid).orElseThrow(() -> new MovieNotFoundException("Movie with id " + guid + " not found"));
    }

}
