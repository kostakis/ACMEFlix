package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.User;
import com.acmeflix.transfer.KeyValue;

import java.math.BigDecimal;
import java.util.List;

public interface MovieService extends BaseService<Movie, Long> {

    List<Movie> findByInitialMovieName(String initialMovieName);

    Movie findByMovieName(String movieName);

    List<Long> getAllIds();
}
