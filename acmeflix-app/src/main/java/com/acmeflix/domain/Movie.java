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
@Table( name = "MOVIES", indexes = {@Index(columnList = "MOVIENAME")})
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "idGenerator", initialValue = 1, allocationSize = 1)
public class Movie extends BaseModel {

    @NotNull ( message = "Movie name can not be null")
    @Column (name = "MOVIENAME", length = 50, nullable = false)
    private String movieName;

    @NotNull(message = "Movie category cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    //Just a description string to make things more easier
    @NotNull(message = "Description can not be null")
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column (nullable = false)
    private Integer movieYear;

    @NotNull
    @Column (nullable = false)
    private Double duration;

    @NotNull
    @Column (nullable = false)
    private Float rating;
}
