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

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImplementation extends BaseServiceImpl<Profile>
        implements ProfileService {

    private final ProfileRepository profileRepository;
    private final MovieService movieService;
    private final TvShowService tvShowService;

    JpaRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

    @Override
    public Profile createUsingHistory(@NotNull Profile profile) {
       var movieHistory = profile.getMovieHistory();
       var tvShowHistory = profile.getTvShowHistory();

       double movieDuration = 0;
       double tvShowDuration = 0;

       for(Long movieId: movieHistory) {
           Movie movie = movieService.find(movieId);
           movieDuration += movie.getDuration();
       }

       for(Long tvShowId: tvShowHistory) {
           TvShow show = tvShowService.find(tvShowId);
           tvShowDuration += show.getDuration();
       }

       profile.setViewedHours(movieDuration + tvShowDuration);

       return create(profile);
    }

    @Override
    public List<Profile> findByUser(@NonNull  User user) {
        profileRepository.findByUser(user);

        return null;
    }
}
