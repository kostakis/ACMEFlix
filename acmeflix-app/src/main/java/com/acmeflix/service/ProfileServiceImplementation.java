package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.transfer.resource.AccountHistory;
import com.acmeflix.transfer.resource.MovieResource;
import com.acmeflix.transfer.resource.ProfileResourceWithHistory;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProfileServiceImplementation extends BaseServiceImpl<Profile>
        implements ProfileService {

    private final UserService userService;
    private final ProfileRepository profileRepository;
    private final MovieService movieService;
    private final TvShowService tvShowService;

    JpaRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

    @Override
    public Profile createUsingHistory(@NotNull Profile profile) {
       var movieHistory = profile.getMovieHistory();

       double movieDuration = 0;
       double tvShowDuration = 0;

       for(Long movieId: movieHistory) {
           Movie movie = movieService.find(movieId);
           movieDuration += movie.getDuration();
       }

       profile.setViewedMinutes(movieDuration + tvShowDuration);

       return create(profile);
    }

    @Override
    public List<Profile> findByUser(@NonNull  User user) {
        return profileRepository.findByUser(user);
    }

    @Override
    @Transactional
    public List<Profile> findByUserEager(@NonNull  User user) {
        var profiles = profileRepository.findByUser(user);
        for (Profile profile: profiles) {
            Hibernate.initialize(profile.getMovieHistory());
            Hibernate.initialize(profile.getTvShowHistory());
        }

        return profiles;
    }

    @Override
    public List<AccountHistory> mapToAccountHistory(List<Long> allUserIds) {
        List<AccountHistory> accountHistoryList = new LinkedList<>();

        for (Long id : allUserIds) { //For each user
            User user = userService.find(id);

            var profiles = findByUserEager(user); //Get all the profiles

            AccountHistory accountHistory = new AccountHistory();
            accountHistory.setUser(user);

            List<ProfileResourceWithHistory> userProfiles = new ArrayList<>();

            for (Profile profile : profiles) { //For each profile of each user
                ProfileResourceWithHistory profileResourceWithHistory = new ProfileResourceWithHistory(profile.getId(), profile.getName(), profile.getViewedMinutes());
                List<MovieResource> movieResources = new ArrayList<>();

                var watchedMovies = profile.getMovieHistory();
                for(Long movie: watchedMovies) { //Get all the watched movies
                    MovieResource movieResource = new MovieResource();
                    movieResource.setMovieName(movieService.get(movie).getMovieName());
                    movieResource.setId(movie);
                    movieResources.add(movieResource);
                }

                profileResourceWithHistory.setMovieHistory(movieResources);
                userProfiles.add(profileResourceWithHistory);
            }

            accountHistoryList.add(accountHistory);
            accountHistory.setProfiles(userProfiles);
        }

        return accountHistoryList;
    }

    @Override
    @Transactional
    public List<Profile> findAllEager() {
        var e = findAll();
        for(Profile profile: e) {
            Hibernate.initialize(profile.getMovieHistory());
            Hibernate.initialize(profile.getTvShowHistory());
        }

        return e;
    }
}
