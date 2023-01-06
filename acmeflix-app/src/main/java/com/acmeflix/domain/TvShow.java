package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table( name = "TVSHOWS", indexes = {@Index(columnList = "tvShowName")})
@NoArgsConstructor
@AllArgsConstructor
public class TvShow extends BaseModel {

    @NotNull
    @Column(length = 50, nullable = false)
    private String tvShowName;

    @NotNull
    @Column(nullable = false)
    Pair<Integer, Integer> seasonEpisode;

    @NotNull(message = "Tv show category cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    Category category;

    @NotNull(message = "Year can not be null")
    @Column(nullable = false)
    private Description description;

    @NotNull( message = "Tv show can not be null")
    @Column(nullable = false)
    private Integer year;

    @NotNull
    @Column (nullable = false)
    private Double duration;

    @NotNull
    @Column (nullable = false)
    private Float rating;
}
