package com.acmeflix.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PROFILES", indexes = {@Index(columnList = "user_id")})
public class Profile extends BaseModel {

    @ManyToOne(optional = false)
    private User user;

    @NotNull(message = "Profile name can not be null")
    @Column(nullable = false)
    private String name;

    @Column
    private Integer viewedMinutes;

    @ElementCollection
    @Column(name = "MOVIEHISTORY")
    private List<Long> movieHistory = new ArrayList<>();

    @ElementCollection
    @Column(name = "TVSHOWHISTORY")
    private List<Long> tvShowHistory = new ArrayList<>();

    public Profile() {
    }

    public Profile(Long id, User user, String name, Integer viewedMinutes, List<Long> movieHistory, List<Long> tvShowHistory) {
        super(id);
        this.user = user;
        this.name = name;
        this.viewedMinutes = viewedMinutes;
        this.movieHistory = movieHistory;
        this.tvShowHistory = tvShowHistory;
    }

    public Profile(User user, String name, Integer viewedMinutes, List<Long> movieHistory, List<Long> tvShowHistory) {
        this.user = user;
        this.name = name;
        this.viewedMinutes = viewedMinutes;
        this.movieHistory = movieHistory;
        this.tvShowHistory = tvShowHistory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getViewedMinutes() {
        return viewedMinutes;
    }

    public void setViewedMinutes(Integer viewedMinutes) {
        this.viewedMinutes = viewedMinutes;
    }

    public List<Long> getMovieHistory() {
        return movieHistory;
    }

    public void setMovieHistory(List<Long> movieHistory) {
        this.movieHistory = movieHistory;
    }

    public List<Long> getTvShowHistory() {
        return tvShowHistory;
    }

    public void setTvShowHistory(List<Long> tvShowHistory) {
        this.tvShowHistory = tvShowHistory;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + getId() +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", viewedMinutes=" + viewedMinutes +
                ", movieHistory=" + movieHistory +
                ", tvShowHistory=" + tvShowHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name) && Objects.equals(user, profile.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, user);
    }
}
