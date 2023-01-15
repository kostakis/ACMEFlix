package com.acmeflix.transfer;

public interface MovieIdAndWatchedCounter extends BaseWatchedInterface{
    String getMovieId();

    Integer getCounter();

    String getMovieName();
}
