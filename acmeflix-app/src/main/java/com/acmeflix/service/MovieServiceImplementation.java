package com.acmeflix.service;

import com.acmeflix.domain.Movie;
//import com.acmeflix.domain.User;
import com.acmeflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImplementation extends BaseServiceImpl<Movie>
        implements MovieService {

    private final MovieRepository movieRepository;
    JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public Movie findByMovieName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }

    }

