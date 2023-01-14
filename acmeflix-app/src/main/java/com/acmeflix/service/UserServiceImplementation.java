package com.acmeflix.service;

import com.acmeflix.domain.User;
import com.acmeflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation extends BaseServiceImpl<User>
        implements UserService {

    private final UserRepository userRepository;

    JpaRepository<User, Long> getRepository() {
        return userRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByemail(email);
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
