package com.acmeflix.controller;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.User;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.MovieService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "movies")
public class MovieController extends BaseController<Movie> {
    private final MovieService movieService;
    private final ProfileService profileService;

    @Override
    BaseService<Movie, Long> getBaseService() {
        return movieService;
    }

    @GetMapping("/topten")
    public ResponseEntity<ApiResponse<?>> findTopTenMovies() {

        var topList = profileService.findMostWatchedContent();

        logger.info("Top ten lsit is: {}", topList);

        return null;
    }

}
