package com.uj.cinema.repository;

import com.uj.cinema.model.entity.Theater;
import com.uj.cinema.model.exception.theater.TheaterNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, String> {

    default Theater getByGuid(final String guid) {
        return this.findById(guid).orElseThrow(() -> new TheaterNotFoundException("Theater with id " + guid + " not found"));
    }
}
