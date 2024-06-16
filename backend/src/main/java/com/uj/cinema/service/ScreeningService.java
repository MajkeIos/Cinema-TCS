package com.uj.cinema.service;

import com.uj.cinema.model.dto.ScreeningDTO;
import com.uj.cinema.model.dto.request.screening.CreateScreeningRequest;
import com.uj.cinema.model.entity.Screening;
import com.uj.cinema.repository.ScreeningRepository;
import com.uj.cinema.utils.GuidGenerator;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    public List<ScreeningDTO> getScreenings(final LocalDateTime start, final LocalDateTime end) {
        if (start == null || end == null) {
            return screeningRepository.findAll().stream().map(Screening::toDTO).toList();
        }
        return screeningRepository.findByTimestampBetween(start, end).stream().map(Screening::toDTO).toList();
    }

    public Screening getScreeningEntityByScreeningId(final String screeningId) {
        return screeningRepository.getByGuid(screeningId);
    }

    public ScreeningDTO getScreeningByScreeningId(final String screeningId) {
        return getScreeningEntityByScreeningId(screeningId).toDTO();
    }

    public ScreeningDTO createScreening(final CreateScreeningRequest request) {
        final Screening screening = Screening.builder()
                .screeningId(generateGuid())
                .movie(movieService.getMovieEntityByMovieId(request.getMovieId()))
                .screen(screenService.getScreenEntityByScreenId(request.getScreenId()))
                .timestamp(request.getTimestamp())
                .screeningReservations(new HashSet<>())
                .build();
        return screeningRepository.save(screening).toDTO();
    }

    public void deleteScreening(final String screeningId) {
        final Screening screening = screeningRepository.getByGuid(screeningId);
        screeningRepository.delete(screening);
    }

    private String generateGuid() {
        return GuidGenerator.generateGuid(Screening.GUID_PREFIX, screeningRepository::existsById);
    }

}
