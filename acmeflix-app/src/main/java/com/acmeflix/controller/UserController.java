package com.acmeflix.controller;

import com.acmeflix.domain.User;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.UserService;
import com.acmeflix.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController extends BaseController<User> {

    private final UserService userService;

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
        checkPositiveId(id);

        ApiResponse<User> apiResponse = new ApiResponse<User>();
        apiResponse.setData(userService.find(id)); //If user not found exception is thrown

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<ApiResponse<?>> findUserByEmail(@RequestParam("email") String email) {
        logger.info("GET request users?email={}", email);

        ApiResponse<User> apiResponse = new ApiResponse<User>();

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
        checkPositiveId(id);

        ApiResponse<String> apiResponse = new ApiResponse<String>();
        apiResponse.setData("Deletion of user id: " + id + " was successfully");

        userService.deleteById(id); //Exception will be thrown if id does not exist. it will be caught by global exception handler

        return ResponseEntity.ok(apiResponse);
    }

    private void checkPositiveId(Long id) {
        if(id < 0) {
            logger.info("Id can not be zero, bad request");
            throw new IllegalArgumentException("User id can not be negative");
        }
    }
}
