package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImplementation extends BaseServiceImpl<Profile>
        implements ProfileService {

    private final ProfileRepository profileRepository;

    JpaRepository<Profile, Long> getRepository() {
        return profileRepository;
    }
}
