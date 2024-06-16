package com.uj.cinema.model.entity;

import com.uj.cinema.model.dto.ScreeningDTO;
import com.uj.cinema.model.enumeration.GuidPrefix;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "screening")
public class Screening {

    public static final String GUID_PREFIX = GuidPrefix.SCREENING.getName();

    @Id
    @Column(name = "id")
    private String screeningId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "screening")
    private Set<ScreeningReservation> screeningReservations;

    public ScreeningDTO toDTO() {
        return ScreeningDTO.builder()
                .screeningId(getScreeningId())
                .movie(getMovie().toDTO())
                .screen(getScreen().toDTO())
                .timestamp(getTimestamp())
                .screeningReservations(getScreeningReservations()
                        .stream()
                        .map(ScreeningReservation::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}