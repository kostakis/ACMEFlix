package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Long> getAllIds() {
        List<Long> allIds = new ArrayList<>();

        var movies = findAll();

        for(Movie m: movies) {
            allIds.add(m.getId());
        }

        return allIds;
    }

}

