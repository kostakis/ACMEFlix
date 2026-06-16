package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import com.acmeflix.transfer.BaseWatchedInterface;
import com.acmeflix.transfer.MovieRatedInterface;
import com.acmeflix.transfer.TvShowRatedInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("profiles/")
public class ProfileController extends BaseController<Profile> {

    private final ProfileService profileService;
    private final UserService userService;

    public ProfileController(ProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }

    @Override
    BaseService<Profile, Long> getBaseService() {
        return profileService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProfiles() {
        logger.info("GET request profiles/");

        var allProfiles = profileService.findAllEager();

        ApiResponse<List<Profile>> response = new ApiResponse<>();
        response.setData(allProfiles);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/topten")
    public ResponseEntity<ApiResponse<?>> findTopTenMovies() {

        var allSeriesAndMovies = profileService.findTopSeriesAndMovies(10);

        ApiResponse<List<BaseWatchedInterface>> response = new ApiResponse<>();
        response.setData(allSeriesAndMovies);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/topRatedMovies")
    public ResponseEntity<ApiResponse<?>> findTopRatedMovies() {
        var allRated = profileService.findTopRatedMovies(10);

        ApiResponse<List<MovieRatedInterface>> response = new ApiResponse<>();
        response.setData(allRated);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/topRatedSeries")
    public ResponseEntity<ApiResponse<?>> findTopTenRatedSeries() {
        var allRated = profileService.findTopRatedTvShows(10);

        ApiResponse<List<TvShowRatedInterface>> response = new ApiResponse<>();
        response.setData(allRated);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/topcategories")
    public ResponseEntity<ApiResponse<?>> findTopCategories() {

        var allSeriesAndMovies = profileService.findTopSeriesAndMovies(10);
        var categories = profileService.findTopCategories(allSeriesAndMovies, 5);

        ApiResponse<List<Map.Entry<Category, Integer>>> response = new ApiResponse<>();
        response.setData(categories);
        return ResponseEntity.ok(response);
    }
}
