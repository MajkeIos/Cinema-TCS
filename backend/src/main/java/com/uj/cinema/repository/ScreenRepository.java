package com.uj.cinema.repository;

import com.uj.cinema.model.entity.Screen;
import com.uj.cinema.model.exception.screen.ScreenNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, String> {

    default Screen getByGuid(final String guid) {
        return this.findById(guid).orElseThrow(() -> new ScreenNotFoundException("Screen with id " + guid + " not found"));
    }

}
