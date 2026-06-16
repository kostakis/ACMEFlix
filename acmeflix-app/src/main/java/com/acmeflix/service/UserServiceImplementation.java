package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.repository.UserRepository;
import com.acmeflix.transfer.resource.UserResource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service

public class UserServiceImplementation extends BaseServiceImpl<User>
        implements UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserServiceImplementation(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByEmail(String email) {
        var user = userRepository.findByemail(email);
        if (user == null) {
            throw new NoSuchElementException("User with email: " + email + " does not exist");
        }
        return user;
    }

    @Override
    public List<Long> getAllIds() {
        List<Long> allIds = new ArrayList<>();
        var e = findAll();
        for (User user : e) {
            allIds.add(user.getId());
        }
        return allIds;
    }

    @Override
    public void update(Long id, Optional<String> email, Optional<String> firstname, Optional<String> lastname, Optional<String> password) {
        User user = find(id); //Will throw if not found
        
        email.ifPresent(user::setEmail);
        firstname.ifPresent(user::setFirstName);
        lastname.ifPresent(user::setLastName);
        password.ifPresent(user::setPassword);

        update(user);
    }

    @Override
    public List<UserResource> toUserResource(List<User> users) {
        List<UserResource> userResources = new ArrayList<>();

        for (User user1 : users) {
            userResources.add(new UserResource(user1.getId(), user1.getEmail(), user1.getFirstName(), user1.getLastName()));
        }

        return userResources;
    }

    @Override
    public UserResource toUserResource(User user) {
        return new UserResource(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

    @Override
    public void deleteById(final Long id) {
        logger.trace("Deleting entity with id {}.", id);

        User user = find(id);

        var profiles = profileRepository.findByUser(user);
        for (Profile profile : profiles) {
            profileRepository.deleteById(profile.getId());
        }

        userRepository.deleteById(id);
    }

    @Override
    public User find(Long id) {
        checkPositiveId(id);

        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Can not find id: " + id));
    }

    private void checkPositiveId(Long id) {
        if (id < 0) {
            logger.info("Id can not be zero, bad request");
            throw new IllegalArgumentException("User id can not be negative");
        }
    }
}
