package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.transfer.resource.UserResource;
import org.mapstruct.control.MappingControl;
import org.springframework.web.bind.annotation.PathVariable;
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

    List<UserResource> toUserResource(List<User> users);

    UserResource toUserResource(User user);
    }
