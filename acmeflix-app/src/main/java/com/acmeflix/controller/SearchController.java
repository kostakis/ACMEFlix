package com.acmeflix.controller;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.User;
import com.acmeflix.service.MovieService;
import com.acmeflix.service.TvShowService;
import com.acmeflix.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "search")
public class SearchController extends AbstractLogComponent  {
    private final MovieService movieService;
    private final TvShowService tvShowService;


    @GetMapping(params = {"name"})
    public ResponseEntity<ApiResponse<?>> findMovieByInitialName(@RequestParam("name") String initialName) {
        logger.info( "Received name: {}", initialName);

        //logger.info("Movie list is: {}", movieList);

        var movieList = movieService.findByInitialMovieName(initialName);



        return null;
    }

}
