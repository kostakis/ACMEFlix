package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.Profile;
import com.acmeflix.domain.TvShow;
import com.acmeflix.domain.User;
import com.acmeflix.repository.MovieRepository;
import com.acmeflix.repository.ProfileRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImplementation extends BaseServiceImpl<Profile>
        implements ProfileService {

    private final ProfileRepository profileRepository;
    private final MovieService movieService;
    private final TvShowService showService;

    JpaRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

    @Override
    public List<Profile> findByUser(@NonNull  User user) {
        profileRepository.findByUser(user);

        return null;
    }


    @Override
    public Profile create(final Profile element) { //Simle insertion to the DB of an entity, a new record
        logger.trace("Creating profile {}.", element);

        createInitialViewingHours(element);
        return profileRepository.save(element);
    }

    private void createInitialViewingHours(Profile profile) {
        int duration = 123;
//        for (Long movieID : profile.getMovieHistory()) {
//            Movie movie = movieService.find(movieID);
//
//            duration += movie.getDuration();
//        }
//
//        for (Long tvShowId : profile.getTvShowHistory()) {
//            TvShow show = showService.find(tvShowId);
//
//            duration += show.getDuration();
//        }

        profile.setViewedHours(duration);
    }
}
