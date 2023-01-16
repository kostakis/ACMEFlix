package com.acmeflix.controller;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import com.acmeflix.transfer.resource.AccountHistory;
import com.acmeflix.transfer.resource.ProfileResource;
import com.acmeflix.transfer.resource.UserResource;
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
    public ResponseEntity<?> findAll() {
        logger.info("GET request users/");

        List<UserResource> allUsers = userService.toUserResource(userService.findAll());

        return ResponseEntity.ok(ApiResponse.<List<UserResource>>builder()
                .data(allUsers)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findUserById(@PathVariable Long id) {
        logger.info("GET request users/{}", id);

        User user = (userService.find(id)); //If user not found exception is thrown

        return ResponseEntity.ok(ApiResponse.<UserResource>builder()
                .data(UserResource.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .id(user.getId())
                        .build())
                .build());
    }

    @GetMapping("/{id}/profiles")
    public ResponseEntity<ApiResponse<?>> getProfileByUserId(@PathVariable Long id,
                                                             @RequestParam("email") Optional<String> history) {
        logger.info("GET request users/{}/profiles", id);

        User user = userService.find(id);
        logger.info("Found user {}", user);

        List<Profile> allProfiles = profileService.findByUser(user);

        //Bad design should have mapper.....
        List<ProfileResource> profileHoursResources =  profileService.toProfileResource(allProfiles);
        return ResponseEntity.ok(ApiResponse.<List<ProfileResource>>builder()
                .data(profileHoursResources)
                .build());
    }

    @GetMapping("/{id}/profiles/history")
    public ResponseEntity<ApiResponse<?>> getProfileHistory(@PathVariable Long id) {
        logger.info("GET request users/{}/profiles/history", id);

        List<AccountHistory> allProfilesAllUsers = profileService.mapToAccountHistory(List.of(id));

        return ResponseEntity.ok(ApiResponse.<List<AccountHistory>>builder()
                .data(allProfilesAllUsers)
                .build());
    }

    @GetMapping("allviewhistory")
    public ResponseEntity<ApiResponse<?>> getAllViewHistory() {
        logger.info("GET request users/allviewhistory");

        List<AccountHistory> allProfilesAllUsers = profileService.mapToAccountHistory(userService.getAllIds());

        return ResponseEntity.ok(ApiResponse.<List<AccountHistory>>builder()
                .data(allProfilesAllUsers)
                .build());
    }


    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<?>> findUserByEmail(@RequestParam("email") String email) {
        logger.info("GET request users?email={}", email);

        User user = userService.findByEmail(email);

        return ResponseEntity.ok(ApiResponse.<User>builder()
                .data(user)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteUserById(@PathVariable Long id) {
        logger.info("DELETE request users/{}", id);

        userService.deleteById(id);

        return ResponseEntity.ok( ApiResponse.<String>builder()
                .data("Deletion of user with id: " + id +" was successfull")
                .build());
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
