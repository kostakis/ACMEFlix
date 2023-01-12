package com.acmeflix.service;

import com.acmeflix.domain.User;

public interface UserService extends BaseService<User, Long> {
    User findByEmail(String email);

    void update(User user);
}
