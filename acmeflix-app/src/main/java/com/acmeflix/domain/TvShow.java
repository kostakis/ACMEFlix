package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.util.Pair;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@SuperBuilder
@Table( name = "TVSHOWS", indexes = {@Index(columnList = "TVSHOWNAME")})
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "idGenerator", initialValue = 1, allocationSize = 1)
public class TvShow extends BaseModel {

    @NotNull
    @Column(name = "TVSHOWNAME", length = 50, nullable = false)
    private String tvShowName;

    @NotNull
    @Column(nullable = false)
    private Integer season;

    @NotNull
    @Column(nullable = false)
    private Integer episode;

    @NotNull(message = "Tv show category cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @NotNull(message = "Description can not be null")
    @Column(nullable = false)
    private String description;

    @NotNull( message = "Tv show can not be null")
    @Column(nullable = false)
    private Integer tvShowYear;

    @NotNull
    @Column (nullable = false)
    private Double duration;

    @NotNull
    @Column (nullable = false)
    private Float rating;
}
