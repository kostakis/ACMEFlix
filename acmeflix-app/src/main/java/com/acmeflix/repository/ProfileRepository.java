package com.acmeflix.repository;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByUser(User user);
}
