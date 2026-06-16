package com.acmeflix.transfer.resource;

import java.util.List;

public class ProfileResourceWithHistory extends ProfileResource {
    private List<MovieResourceHistoryResource> movieHistory;
    private List<TvShowHistoryResource> tvHistory;

    public ProfileResourceWithHistory() {
    }

    public ProfileResourceWithHistory(Long profileID, String profileName, Integer viewedMinutes) {
        super(profileID, profileName, viewedMinutes);
    }

    public ProfileResourceWithHistory(Long profileID, String profileName, Integer viewedMinutes, List<MovieResourceHistoryResource> movieHistory, List<TvShowHistoryResource> tvHistory) {
        super(profileID, profileName, viewedMinutes);
        this.movieHistory = movieHistory;
        this.tvHistory = tvHistory;
    }

    public List<MovieResourceHistoryResource> getMovieHistory() {
        return movieHistory;
    }

    public void setMovieHistory(List<MovieResourceHistoryResource> movieHistory) {
        this.movieHistory = movieHistory;
    }

    public List<TvShowHistoryResource> getTvHistory() {
        return tvHistory;
    }

    public void setTvHistory(List<TvShowHistoryResource> tvHistory) {
        this.tvHistory = tvHistory;
    }

    @Override
    public String toString() {
        return "ProfileResourceWithHistory{" +
                "profileID=" + getProfileID() +
                ", profileName='" + getProfileName() + '\'' +
                ", viewedMinutes=" + getViewedMinutes() +
                ", movieHistory=" + movieHistory +
                ", tvHistory=" + tvHistory +
                '}';
    }
}
