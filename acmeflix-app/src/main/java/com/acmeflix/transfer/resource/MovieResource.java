package com.acmeflix.transfer.resource;

import com.acmeflix.domain.enumeration.Category;

public class MovieResource extends BaseResource {
    private String movieName;
    private String description;
    private Integer movieYear;
    private Category category;
    private Integer duration;
    private Long id;
    private Float rating;

    public MovieResource() {
    }

    public MovieResource(String movieName, String description, Integer movieYear, Category category, Integer duration, Long id, Float rating) {
        this.movieName = movieName;
        this.description = description;
        this.movieYear = movieYear;
        this.category = category;
        this.duration = duration;
        this.id = id;
        this.rating = rating;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieResource{" +
                "movieName='" + movieName + '\'' +
                ", description='" + description + '\'' +
                ", movieYear=" + movieYear +
                ", category=" + category +
                ", duration=" + duration +
                ", id=" + id +
                ", rating=" + rating +
                '}';
    }
}
