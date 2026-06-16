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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "users")
public class UserController extends BaseController<User> {

    private final UserService userService;
    private final ProfileService profileService;

    public UserController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @Override
    BaseService<User, Long> getBaseService() {
        return userService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        logger.info("GET request users/");

        List<UserResource> allUsers = userService.toUserResource(userService.findAll());

        ApiResponse<List<UserResource>> response = new ApiResponse<>();
        response.setData(allUsers);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> findUserById(@PathVariable Long id) {
        logger.info("GET request users/{}", id);

        User user = (userService.find(id));

        UserResource userResource = new UserResource(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName());
        ApiResponse<UserResource> response = new ApiResponse<>();
        response.setData(userResource);
        response.setData(userResource);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/profiles")
    public ResponseEntity<ApiResponse<?>> getProfileByUserId(@PathVariable Long id,
                                                             @RequestParam("email") Optional<String> history) {
        logger.info("GET request users/{}/profiles", id);

        User user = userService.find(id);
        logger.info("Found user {}", user);

        List<Profile> allProfiles = profileService.findByUser(user);

        List<ProfileResource> profileHoursResources = profileService.toProfileResource(allProfiles);
        ApiResponse<List<ProfileResource>> profileResponse = new ApiResponse<>();
        profileResponse.setData(profileHoursResources);
        return ResponseEntity.ok(profileResponse);
    }

    @GetMapping("/{id}/profiles/history")
    public ResponseEntity<ApiResponse<?>> getProfileHistory(@PathVariable Long id) {
        logger.info("GET request users/{}/profiles/history", id);

        List<AccountHistory> allProfilesAllUsers = profileService.mapToAccountHistory(List.of(id));

        ApiResponse<List<AccountHistory>> historyResponse = new ApiResponse<>();
        historyResponse.setData(allProfilesAllUsers);
        return ResponseEntity.ok(historyResponse);
    }

    @GetMapping("allviewhistory")
    public ResponseEntity<ApiResponse<?>> getAllViewHistory() {
        logger.info("GET request users/allviewhistory");

        List<AccountHistory> allProfilesAllUsers = profileService.mapToAccountHistory(userService.getAllIds());

        ApiResponse<List<AccountHistory>> allHistoryResponse = new ApiResponse<>();
        allHistoryResponse.setData(allProfilesAllUsers);
        return ResponseEntity.ok(allHistoryResponse);
    }


    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<?>> findUserByEmail(@RequestParam("email") String email) {
        logger.info("GET request users?email={}", email);

        User user = userService.findByEmail(email);

        ApiResponse<User> userResponse = new ApiResponse<>();
        userResponse.setData(user);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteUserById(@PathVariable Long id) {
        logger.info("DELETE request users/{}", id);

        userService.deleteById(id);

        ApiResponse<String> deleteResponse = new ApiResponse<>();
        deleteResponse.setData("Deletion of user with id: " + id + " was successfull");
        return ResponseEntity.ok(deleteResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateExistingUser(@PathVariable Long id,
                                                @RequestParam("email") Optional<String> email,
                                                @RequestParam("firstname") Optional<String> firstname,
                                                @RequestParam("lastname") Optional<String> lastname,
                                                @RequestParam("password") Optional<String> password) {
        userService.update(id, email, firstname, lastname, password);
        return ResponseEntity.ok("User Updated");
    }
}
