package com.acmeflix.transfer.resource;

public class TvShowHistoryResource extends BaseResource {
    private Long id;
    private String tvShowName;

    public TvShowHistoryResource() {
    }

    public TvShowHistoryResource(Long id, String tvShowName) {
        this.id = id;
        this.tvShowName = tvShowName;
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

    @Override
    public String toString() {
        return "TvShowHistoryResource{" +
                "id=" + id +
                ", tvShowName='" + tvShowName + '\'' +
                '}';
    }
}
