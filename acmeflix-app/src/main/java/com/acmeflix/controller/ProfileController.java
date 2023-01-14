package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //Print all users
    @GetMapping
    public ResponseEntity<?> getAllProfiles() {
        logger.info("GET request profiles/");

        var e = profileService.findAllEager();

        ApiResponse<List<Profile>> allProfiles = new ApiResponse<>();
        allProfiles.setData(e);

        return ResponseEntity.ok(allProfiles);
    }
}
