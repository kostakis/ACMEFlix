package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.User;

public interface MovieService extends BaseService<Movie, Long> {
    Movie findByMovieName(String movieName);

}
