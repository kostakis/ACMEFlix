package com.acmeflix.service;

import com.acmeflix.domain.User;
import com.acmeflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation extends BaseServiceImpl<User>
        implements UserService {

    private final UserRepository userRepository;

    JpaRepository<User, Long> getRepository() {
        return userRepository;
    }
}
