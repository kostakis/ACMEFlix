package com.acmeflix.service;

import com.acmeflix.domain.User;
import com.acmeflix.transfer.resource.UserResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService<User, Long> {
    User findByEmail(String email);

    List<Long> getAllIds();

    void update(Long id, @RequestParam("email") Optional<String> email,
                @RequestParam("firstname") Optional<String> firstname,
                @RequestParam("lastname") Optional<String> lastname,
                @RequestParam("password") Optional<String> password);

    // From User list to user resource list
    List<UserResource> toUserResource(List<User> users);

    // From user to user resource
    UserResource toUserResource(User user);
}
