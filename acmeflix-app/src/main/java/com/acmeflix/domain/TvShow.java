package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Category;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TVSHOWS", indexes = {@Index(columnList = "TVSHOWNAME")})
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
    private List<TvShowEpisodes> episode = new ArrayList<>();

    public TvShow() {
    }

    public TvShow(Long id, String tvShowName, Category category, Float rating, Integer tvShowYear, List<TvShowEpisodes> episode) {
        super(id);
        this.tvShowName = tvShowName;
        this.category = category;
        this.rating = rating;
        this.tvShowYear = tvShowYear;
        this.episode = episode;
    }

    public TvShow(String tvShowName, Category category, Float rating, Integer tvShowYear, List<TvShowEpisodes> episode) {
        this.tvShowName = tvShowName;
        this.category = category;
        this.rating = rating;
        this.tvShowYear = tvShowYear;
        this.episode = episode;
    }

    public String getTvShowName() {
        return tvShowName;
    }

    public void setTvShowName(String tvShowName) {
        this.tvShowName = tvShowName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getTvShowYear() {
        return tvShowYear;
    }

    public void setTvShowYear(Integer tvShowYear) {
        this.tvShowYear = tvShowYear;
    }

    public List<TvShowEpisodes> getEpisode() {
        return episode;
    }

    public void setEpisode(List<TvShowEpisodes> episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "TvShow{" +
                "id=" + getId() +
                ", tvShowName='" + tvShowName + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", tvShowYear=" + tvShowYear +
                ", episode=" + episode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvShow tvShow = (TvShow) o;
        return tvShowName != null ? tvShowName.equals(tvShow.tvShowName) : tvShow.tvShowName == null;
    }

    @Override
    public int hashCode() {
        return tvShowName != null ? tvShowName.hashCode() : 0;
    }
}
