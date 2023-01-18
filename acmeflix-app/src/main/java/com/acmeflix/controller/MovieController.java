package com.acmeflix.controller;

import com.acmeflix.domain.Movie;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.MovieService;
import com.acmeflix.transfer.ApiResponse;
import com.acmeflix.transfer.resource.MovieResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "movies")
public class MovieController extends BaseController<Movie>{
    private final MovieService movieService;
    @Override
    BaseService<Movie, Long> getBaseService() {
        return movieService;
    }
    @GetMapping
    public ResponseEntity<?> findAll() {
        logger.info("GET request movies/");

        List<MovieResource> allMovies = movieService.toMovieResource(movieService.findAll());

        return ResponseEntity.ok(ApiResponse.<List<MovieResource>>builder()
                .data(allMovies)
                .build());
    }
}
