package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.repository.MovieRepository;
import com.acmeflix.transfer.resource.MovieResource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MovieServiceImplementation extends BaseServiceImpl<Movie>
        implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImplementation(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    JpaRepository<Movie, Long> getRepository() {
        return movieRepository;
    }

    @Override
    public List<Movie> findByInitialMovieName(String initialMovieName) {

        List<Movie> movieList = movieRepository.findBymovieNameStartingWithIgnoreCase(initialMovieName);
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

        for (Movie m : movies) {
            allIds.add(m.getId());
        }

        return allIds;
    }

    @Override
    public List<MovieResource> toMovieResource(List<Movie> movies) {
        List<MovieResource> movieResources = new ArrayList<>();

        for (Movie movie1 : movies) {
            MovieResource resource = new MovieResource(movie1.getMovieName(), movie1.getDescription(), movie1.getMovieYear(), movie1.getCategory(), movie1.getDuration(), movie1.getId(), movie1.getRating());
            movieResources.add(resource);
        }

        return movieResources;
    }

}

