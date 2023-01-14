package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;

import java.util.List;

public interface ProfileService extends BaseService<Profile, Long> {

    Profile createUsingHistory(Profile profile);

    List<Profile> findByUser(User user);
}