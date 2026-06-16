package com.acmeflix.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TVSHOWEPISODES")
public class TvShowEpisodes extends BaseModel {

    @NotNull
    @Column(nullable = false)
    private Integer season;

    @Column(nullable = false)
    private Integer episode;

    @NotNull
    @Column(nullable = false)
    private Integer duration;

    public TvShowEpisodes() {
    }

    public TvShowEpisodes(Long id, Integer season, Integer episode, Integer duration) {
        super(id);
        this.season = season;
        this.episode = episode;
        this.duration = duration;
    }

    public TvShowEpisodes(Integer season, Integer episode, Integer duration) {
        this.season = season;
        this.episode = episode;
        this.duration = duration;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "TvShowEpisodes{" +
                "id=" + getId() +
                ", season=" + season +
                ", episode=" + episode +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvShowEpisodes that = (TvShowEpisodes) o;
        return season != null && season.equals(that.season) && episode != null && episode.equals(that.episode);
    }

    @Override
    public int hashCode() {
        return season != null && episode != null ? season.hashCode() * 31 + episode.hashCode() : 0;
    }
}
