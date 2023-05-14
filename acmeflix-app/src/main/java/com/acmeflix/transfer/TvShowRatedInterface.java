package com.acmeflix.transfer;

public interface TvShowRatedInterface extends Comparable<TvShowRatedInterface> {
    String getTvShowName();

    Float getTvShowRating();

    @Override
    default int compareTo(TvShowRatedInterface other) {
        return (int) (other.getTvShowRating() - getTvShowRating());
    }
}
