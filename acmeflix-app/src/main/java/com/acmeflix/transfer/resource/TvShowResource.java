package com.acmeflix.transfer.resource;

public class TvShowResource extends BaseResource {
    private Long id;
    private String tvShowName;
    private Float rating;

    public TvShowResource() {
    }

    public TvShowResource(Long id, String tvShowName, Float rating) {
        this.id = id;
        this.tvShowName = tvShowName;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTvShowName() {
        return tvShowName;
    }

    public void setTvShowName(String tvShowName) {
        this.tvShowName = tvShowName;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "TvShowResource{" +
                "id=" + id +
                ", tvShowName='" + tvShowName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
