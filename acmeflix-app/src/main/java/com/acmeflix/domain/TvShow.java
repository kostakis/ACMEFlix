package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@SuperBuilder
@Table(name = "TVSHOWS", indexes = {@Index(columnList = "TVSHOWNAME")})
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "idGenerator", initialValue = 1, allocationSize = 1)
public class TvShow extends BaseModel {

    @NotNull
    @Column(name = "TVSHOWNAME", length = 50, unique = true, nullable = false)
    private String tvShowName;

    @NotNull(message = "Tv show category cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @NotNull
    @Column(nullable = false)
    private Float rating;

    @NotNull(message = "Tv show year can not be null")
    @Column(nullable = false)
    private Integer tvShowYear;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TvShowEpisodes> episode = new ArrayList<>(); //NULL
}
