package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import com.acmeflix.transfer.BaseWatchedInterface;
import com.acmeflix.transfer.MovieIdAndWatchedCounter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("profiles/")
public class ProfileController extends BaseController<Profile>{

    private final ProfileService profileService;
    private final UserService userService;

    @Override
    BaseService<Profile, Long> getBaseService() {
        return profileService;
    }

    @GetMapping
    public ResponseEntity<?> getAllProfiles() {
        logger.info("GET request profiles/");

        var e = profileService.findAllEager();

        ApiResponse<List<Profile>> allProfiles = new ApiResponse<>();
        allProfiles.setData(e);

        return ResponseEntity.ok(allProfiles);
    }


    @GetMapping("/topten")
    public ResponseEntity<ApiResponse<?>> findTopTenMovies() {

        var allSeriesAndMovies = profileService.findTopSeriesAndMovies(10);

        ApiResponse<List<BaseWatchedInterface>> apiResponse = new ApiResponse<>();
        apiResponse.setData(allSeriesAndMovies);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/topcategories")
    public ResponseEntity<ApiResponse<?>> findTopCategories() {

        var allSeriesAndMovies = profileService.findTopSeriesAndMovies(10);
        var categories = profileService.findTopCategories(allSeriesAndMovies, 5);

        ApiResponse<HashMap<Category, Integer>> apiResponse = new ApiResponse<>();
        apiResponse.setData(categories);

        return ResponseEntity.ok(apiResponse);
    }
}
