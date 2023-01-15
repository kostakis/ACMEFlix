package com.acmeflix.transfer;

public interface TvShowIdAndWatchedCounter extends BaseWatchedInterface {
    String getTvShowId();

    Integer getCounter();

    String getTvShowName();
}
