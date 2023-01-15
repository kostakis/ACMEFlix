package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import com.acmeflix.transfer.resource.AccountHistory;
import com.acmeflix.transfer.resource.ProfileResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController extends BaseController<User> {

    private final UserService userService;
    private final ProfileService profileService;

    @Override
    BaseService<User, Long> getBaseService() {
        return userService;
    }

    //Print all users
    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> findAll() {
        logger.info("GET request users/");

        List<User> allUsers = userService.findAll();

        ApiResponse<List<User>> apiResponse = new ApiResponse<List<User>>();
        apiResponse.setData(allUsers);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findUserById(@PathVariable Long id) {
        logger.info("GET request users/{}", id);

        ApiResponse<User> apiResponse = new ApiResponse<User>();
        apiResponse.setData(userService.find(id)); //If user not found exception is thrown

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}/profiles")
    public ResponseEntity<ApiResponse<?>> getProfileByUserId(@PathVariable Long id) {
        logger.info("GET request /{}/profiles", id);

        User user = userService.find(id);
        logger.info("Found user {}", user);

        List<Profile> allProfiles = profileService.findByUser(user);

        List<ProfileResource> profileHoursResources = new ArrayList<>();
        for (Profile profile : allProfiles) {
            logger.info("Viewed minutes {}", profile.getViewedMinutes());
            profileHoursResources.add(ProfileResource.builder()
                    .profileID(profile.getId())
                    .viewedMinutes(profile.getViewedMinutes())
                    .profileName(profile.getName())
                    .build());
        }


        ApiResponse<List<ProfileResource>> apiResponse = new ApiResponse<>();
        apiResponse.setData(profileHoursResources);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("allviewhistory")
    public ResponseEntity<ApiResponse<?>> getAllViewHistory() {
        logger.info("GET request users/allviewhistory");

        List<AccountHistory> allProfilesAllUsers = profileService.mapToAccountHistory(userService.getAllIds());

        List<AccountHistory> accountHistory = new ArrayList<>();

        ApiResponse<List<AccountHistory>> apiResponse = new ApiResponse<>();
        apiResponse.setData(allProfilesAllUsers);

        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<?>> findUserByEmail(@RequestParam("email") String email) {
        logger.info("GET request users?email={}", email);

        ApiResponse<User> apiResponse = new ApiResponse<>();

        User user = userService.findByEmail(email);
        if(user == null) {
            throw new NoSuchElementException("User with email: " + email + " does not exist");
        } else {
            apiResponse.setData(userService.findByEmail(email));
            return ResponseEntity.ok(apiResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteUserById(@PathVariable Long id) {
        logger.info("DELETE request users/{}", id);

        ApiResponse<String> apiResponse = new ApiResponse<String>();
        apiResponse.setData("Deletion of user id: " + id + " was successfully");

        userService.deleteById(id); //Exception will be thrown if id does not exist. it will be caught by global exception handler

        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> updateExistingUser(@PathVariable Long id,
                                                @RequestParam("email") Optional<String> email,
                                                @RequestParam("firstname") Optional<String> firstname,
                                                @RequestParam("lastname") Optional<String> lastname,
                                                @RequestParam("password") Optional<String> password)
    {
        userService.update(id, email, firstname, lastname, password);
        return ResponseEntity.ok("User Updated");
    }
}
