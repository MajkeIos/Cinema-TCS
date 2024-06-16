package com.uj.cinema.model.entity;

import com.uj.cinema.model.dto.TheaterDTO;
import com.uj.cinema.model.enumeration.GuidPrefix;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "theater")
public class Theater {

    public static final String GUID_PREFIX = GuidPrefix.MOVIE.getName();

    @Id
    @Column(name = "id")
    private String theaterId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    public TheaterDTO toDTO() {
        return TheaterDTO.builder()
                .theaterId(getTheaterId())
                .name(getName())
                .location(getLocation())
                .build();
    }

}