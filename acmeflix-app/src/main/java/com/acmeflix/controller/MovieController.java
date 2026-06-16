package com.acmeflix.controller;

import com.acmeflix.domain.Movie;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.MovieService;
import com.acmeflix.transfer.ApiResponse;
import com.acmeflix.transfer.resource.MovieResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "movies")
public class MovieController extends BaseController<Movie> {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        logger.info("GET request movies/");

        List<MovieResource> allMovies = movieService.toMovieResource(movieService.findAll());

        ApiResponse<List<MovieResource>> response = new ApiResponse<>();
        response.setData(allMovies);
        return ResponseEntity.ok(response);
    }
}
