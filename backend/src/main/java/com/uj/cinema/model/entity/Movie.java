package com.uj.cinema.model.entity;

import com.uj.cinema.model.dto.MovieDTO;
import com.uj.cinema.model.enumeration.GuidPrefix;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    public static final String GUID_PREFIX = GuidPrefix.MOVIE.getName();

    @Id
    @Column(name = "id")
    private String movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    private String rating;

    @OneToMany(mappedBy = "movie")
    private Set<Screening> screenings;

    public MovieDTO toDTO() {
        return MovieDTO.builder()
                .movieId(getMovieId())
                .title(getTitle())
                .description(getDescription())
                .duration(getDuration())
                .releaseDate(getReleaseDate())
                .rating(getRating())
                .build();
    }

}