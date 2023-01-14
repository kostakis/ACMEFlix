package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation extends BaseServiceImpl<User>
        implements UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByemail(email);
    }

    @Override
    public List<Long> getAllIds() {
        List<Long> allIds = new ArrayList<>();
        var e = findAll();
        for(User user: e) {
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
    public void deleteById(final Long id) {
        logger.trace("Deleting entity with id {}.", id);

        User user = find(id);

        var profiles = profileRepository.findByUser(user);
        for(Profile profile: profiles) {
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
        if(id < 0) {
            logger.info("Id can not be zero, bad request");
            throw new IllegalArgumentException("User id can not be negative");
        }
    }
}
