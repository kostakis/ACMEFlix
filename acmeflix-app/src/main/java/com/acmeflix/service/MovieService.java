package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.User;

import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {

    List<Movie> findByInitialMovieName(String initialMovieName);

    Movie findByMovieName(String movieName);
}
