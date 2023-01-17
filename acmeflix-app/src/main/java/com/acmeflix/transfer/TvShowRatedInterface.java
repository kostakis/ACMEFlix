package com.acmeflix.transfer;

public interface TvShowRatedInterface  extends Comparable<TvShowRatedInterface> {
    String getTvShowName();

    Float getTvShowRating();

    @Override
    public default int compareTo(TvShowRatedInterface a) {
        return (int)(a.getTvShowRating() - this.getTvShowRating());
    }
}
