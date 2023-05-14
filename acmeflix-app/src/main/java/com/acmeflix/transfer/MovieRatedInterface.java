package com.acmeflix.transfer;

public interface MovieRatedInterface extends Comparable<MovieRatedInterface> {

    String getMovieName();

    Float getMovieRating();

    @Override
    default int compareTo(MovieRatedInterface a) {
        return (int) (a.getMovieRating() - this.getMovieRating());
    }
}
