package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MOVIES", indexes = {@Index(columnList = "MOVIENAME")})
@SequenceGenerator(name = "idGenerator", initialValue = 1, allocationSize = 1)
public class Movie extends BaseModel {

    @NotNull(message = "Movie name can not be null")
    @Column(name = "MOVIENAME", length = 50, nullable = false)
    private String movieName;

    @NotNull(message = "Movie category cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;

    @NotNull(message = "Description can not be null")
    @Column(nullable = false)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Integer movieYear;

    @NotNull
    @Column(nullable = false)
    private Integer duration;

    @NotNull
    @Column(nullable = false)
    private Float rating;

    public Movie() {
    }

    public Movie(Long id, String movieName, Category category, String description, Integer movieYear, Integer duration, Float rating) {
        super(id);
        this.movieName = movieName;
        this.category = category;
        this.description = description;
        this.movieYear = movieYear;
        this.duration = duration;
        this.rating = rating;
    }

    public Movie(String movieName, Category category, String description, Integer movieYear, Integer duration, Float rating) {
        this.movieName = movieName;
        this.category = category;
        this.description = description;
        this.movieYear = movieYear;
        this.duration = duration;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(Integer movieYear) {
        this.movieYear = movieYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", movieName='" + movieName + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", movieYear=" + movieYear +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieName != null ? movieName.equals(movie.movieName) : movie.movieName == null;
    }

    @Override
    public int hashCode() {
        return movieName != null ? movieName.hashCode() : 0;
    }
}
