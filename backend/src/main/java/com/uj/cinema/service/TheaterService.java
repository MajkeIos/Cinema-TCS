package com.uj.cinema.service;

import com.uj.cinema.model.dto.TheaterDTO;
import com.uj.cinema.model.dto.request.theater.CreateTheaterRequest;
import com.uj.cinema.model.dto.request.theater.UpdateTheaterRequest;
import com.uj.cinema.model.entity.Theater;
import com.uj.cinema.repository.TheaterRepository;
import com.uj.cinema.utils.GuidGenerator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;

    public List<TheaterDTO> getAllTheaters() {
        return theaterRepository.findAll().stream().map(Theater::toDTO).toList();
    }

    protected Theater getTheaterEntityByTheaterId(final String theaterId) {
        return theaterRepository.getByGuid(theaterId);
    }

    public TheaterDTO getTheaterByTheaterId(final String theaterId) {
        return getTheaterEntityByTheaterId(theaterId).toDTO();
    }

    public TheaterDTO createTheater(final CreateTheaterRequest request) {
        final Theater theater = Theater.builder()
                .theaterId(generateGuid())
                .name(request.getName())
                .location(request.getLocation())
                .build();
        return theaterRepository.save(theater).toDTO();
    }

    public TheaterDTO updateTheaterByTheaterId(final String theaterId, final UpdateTheaterRequest request) {
        final Theater theater = theaterRepository.getByGuid(theaterId);

        theater.setName(request.getName());
        theater.setLocation(request.getLocation());

        return theaterRepository.save(theater).toDTO();
    }

    public void deleteTheater(final String theaterId) {
        final Theater theater = theaterRepository.getByGuid(theaterId);
        theaterRepository.delete(theater);
    }

    private String generateGuid() {
        return GuidGenerator.generateGuid(Theater.GUID_PREFIX, theaterRepository::existsById);
    }

}
