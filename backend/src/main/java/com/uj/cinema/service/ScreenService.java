package com.uj.cinema.service;

import com.uj.cinema.model.dto.ScreenDTO;
import com.uj.cinema.model.dto.request.screen.CreateScreenRequest;
import com.uj.cinema.model.dto.request.screen.UpdateScreenRequest;
import com.uj.cinema.model.entity.Screen;
import com.uj.cinema.repository.ScreenRepository;
import com.uj.cinema.utils.GuidGenerator;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final TheaterService theaterService;

    protected Screen getScreenEntityByScreenId(final String screenId) {
        return screenRepository.getByGuid(screenId);
    }

    public ScreenDTO getScreenByScreenId(final String screenId) {
        return getScreenEntityByScreenId(screenId).toDTO();
    }

    public ScreenDTO createScreen(final CreateScreenRequest request) {
        final Screen screen = Screen.builder()
                .screenId(generateGuid())
                .theater(theaterService.getTheaterEntityByTheaterId(request.getTheaterId()))
                .name(request.getName())
                .numberOfRows(request.getNumberOfRows())
                .numberOfColumns(request.getNumberOfColumns())
                .screenings(new HashSet<>())
                .build();
        return screenRepository.save(screen).toDTO();
    }

    public ScreenDTO updateScreenByScreenId(final String screenId, final UpdateScreenRequest request) {
        final Screen screen = screenRepository.getByGuid(screenId);

        screen.setTheater(theaterService.getTheaterEntityByTheaterId(request.getTheaterId()));
        screen.setName(request.getName());
        screen.setNumberOfRows(request.getNumberOfRows());
        screen.setNumberOfColumns(request.getNumberOfColumns());

        return screenRepository.save(screen).toDTO();
    }

    public void deleteScreen(final String screenId) {
        final Screen screen = screenRepository.getByGuid(screenId);
        screenRepository.delete(screen);
    }

    private String generateGuid() {
        return GuidGenerator.generateGuid(Screen.GUID_PREFIX, screenRepository::existsById);
    }

}
