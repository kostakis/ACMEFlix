package com.acmeflix.service;

import com.acmeflix.domain.Movie;
//import com.acmeflix.domain.User;
import com.acmeflix.repository.MovieRepository;
import com.acmeflix.transfer.KeyValue;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImplementation extends BaseServiceImpl<Movie>
        implements MovieService {

    private final MovieRepository movieRepository;

    JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public List<Movie> findByInitialMovieName(String initialMovieName) {

        List<Movie> movieList =  movieRepository.findBymovieNameStartingWith(initialMovieName);
        return movieList;
    }

    @Override
    public Movie findByMovieName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }

}

