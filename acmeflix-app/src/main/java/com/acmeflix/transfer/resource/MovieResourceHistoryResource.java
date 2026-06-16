package com.acmeflix.transfer.resource;

public class MovieResourceHistoryResource extends BaseResource {
    private String movieName;
    private Long id;

    public MovieResourceHistoryResource() {
    }

    public MovieResourceHistoryResource(String movieName, Long id) {
        this.movieName = movieName;
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MovieResourceHistoryResource{" +
                "movieName='" + movieName + '\'' +
                ", id=" + id +
                '}';
    }
}
