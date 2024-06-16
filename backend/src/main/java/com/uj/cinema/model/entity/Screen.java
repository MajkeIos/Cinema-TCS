package com.uj.cinema.model.entity;

import com.uj.cinema.model.dto.ScreenDTO;
import com.uj.cinema.model.enumeration.GuidPrefix;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "screen")
public class Screen {

    public static final String GUID_PREFIX = GuidPrefix.SCREEN.getName();

    @Id
    @Column(name = "id")
    private String screenId;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @Column(nullable = false)
    private String name;

    @Column(name = "number_of_rows", nullable = false)
    private Integer numberOfRows;

    @Column(name = "number_of_columns", nullable = false)
    private Integer numberOfColumns;

    @OneToMany(mappedBy = "screen")
    private Set<Screening> screenings;

    public ScreenDTO toDTO() {
        return ScreenDTO.builder()
                .screenId(getScreenId())
                .theater(getTheater().toDTO())
                .name(getName())
                .numberOfRows(getNumberOfRows())
                .numberOfColumns(getNumberOfColumns())
                .build();
    }

}