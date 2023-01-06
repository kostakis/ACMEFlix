package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table( name = "MOVIES", indexes = {@Index(columnList = "movieName")})
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseModel {

    @NotNull ( message = "Movie name can not be null")
    @Column (length = 50, nullable = false)
    private String movieName;

    //TODO CHECK THIS
    @NotNull(message = "Movie category cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @NotNull(message = "Year can not be null")
    @Column(nullable = false)
    private Description description;

    @NotNull(message = "Year can not be null")
    @Column(nullable = false)
    private Integer year;

    @NotNull
    @Column (nullable = false)
    private Double duration;

    @NotNull
    @Column (nullable = false)
    private Float rating;
}
