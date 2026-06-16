package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.TvShow;
import com.acmeflix.domain.TvShowEpisodes;
import com.acmeflix.domain.User;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.transfer.*;
import com.acmeflix.transfer.resource.*;


import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.*;

@Service

@Transactional
public class ProfileServiceImplementation extends BaseServiceImpl<Profile>
        implements ProfileService {

    private final UserService userService;
    private final ProfileRepository profileRepository;
    private final MovieService movieService;
    private final TvShowService tvShowService;

    public ProfileServiceImplementation(UserService userService, ProfileRepository profileRepository, MovieService movieService, TvShowService tvShowService) {
        this.userService = userService;
        this.profileRepository = profileRepository;
        this.movieService = movieService;
        this.tvShowService = tvShowService;
    }

    JpaRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

    @Override
    public Profile createUsingHistory(@NotNull Profile profile) {
        var movieHistory = profile.getMovieHistory();
        var tvShowHistory = profile.getTvShowHistory();

        var movieDuration = 0;
        var tvShowDuration = 0;

        for (Long movieId : movieHistory) {
            movieDuration += movieService.find(movieId).getDuration();
        }

        for (Long tvShowId : tvShowHistory) {
            TvShow tvShow = tvShowService.find(tvShowId);
            var allEpisodes = tvShow.getEpisode();

            for (TvShowEpisodes episode : allEpisodes) { //Just assume he has watched all the episodes
                tvShowDuration += episode.getDuration();
            }
        }

        profile.setViewedMinutes(movieDuration + tvShowDuration);

        return create(profile);
    }

    @Override
    public List<Profile> findByUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        return profileRepository.findByUser(user);
    }

    @Override
    @Transactional
    public List<Profile> findByUserEager(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        var profiles = profileRepository.findByUser(user);
        for (Profile profile : profiles) {
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

            var profiles = findByUserEager(user); //Get all the profiles among with the histories

            List<ProfileResourceWithHistory> userProfiles = new ArrayList<>();

            for (Profile profile : profiles) {
                List<MovieResourceHistoryResource> movieResources = new ArrayList<>();
                List<TvShowHistoryResource> tvShowResources = new ArrayList<>();

                var watchedMovies = profile.getMovieHistory();
                for (Long movie : watchedMovies) {
                    movieResources.add(new MovieResourceHistoryResource(movieService.get(movie).getMovieName(), movie));
                }

                var watchedShows = profile.getTvShowHistory();
                for (Long showId : watchedShows) {
                    tvShowResources.add(new TvShowHistoryResource(showId, tvShowService.get(showId).getTvShowName()));
                }

                ProfileResourceWithHistory profileWithHistory = new ProfileResourceWithHistory(profile.getId(), profile.getName(), profile.getViewedMinutes(), movieResources, tvShowResources);
                userProfiles.add(profileWithHistory);
            }

            accountHistoryList.add(new AccountHistory(userService.toUserResource(user), userProfiles));
        }

        return accountHistoryList;
    }

    @Override
    @Transactional
    public List<Profile> findAllEager() {
        var e = findAll();
        for (Profile profile : e) {
            Hibernate.initialize(profile.getMovieHistory());
            Hibernate.initialize(profile.getTvShowHistory());
        }

        return e;
    }

    @Override
    public List<MovieIdAndWatchedCounter> findTopMovies(int max) {
        return profileRepository.findTopMovies(max);
    }

    @Override
    public List<TvShowIdAndWatchedCounter> findTopSeries(int max) {
        return profileRepository.findTopSeries(max);
    }

    @Override
    public List<MovieRatedInterface> findTopRatedMovies(int max) {
        var movies = profileRepository.findTopRatedMovies(max);
        List<MovieRatedInterface> allRated = new ArrayList<>(movies);

        // Sort the list and keep only the max
        allRated = allRated.stream().sorted().limit(max).toList();
        return allRated;
    }

    @Override
    public List<TvShowRatedInterface> findTopRatedTvShows(int max) {
        var series = profileRepository.findTopRatedTvShows(max);
        List<TvShowRatedInterface> allRated = new ArrayList<>(series);

        // Sort the list and keep only the max
        allRated = allRated.stream().sorted().limit(max).toList();
        return allRated;
    }

    @Override
    public List<BaseWatchedInterface> findTopSeriesAndMovies(int max) {
        var movies = findTopMovies(max);
        var series = findTopSeries(max);

        List<BaseWatchedInterface> allSeriesAndMovies = new ArrayList<>();
        allSeriesAndMovies.addAll(series);
        allSeriesAndMovies.addAll(movies);

        //Keep only 10
        allSeriesAndMovies = allSeriesAndMovies.stream().sorted().limit(max).toList();

        return allSeriesAndMovies;

    }

    @Override
    public List<Map.Entry<Category, Integer>> findTopCategories(List<BaseWatchedInterface> content, int max) {
        HashMap<Category, Integer> cateogiresAndCounter = new HashMap<Category, Integer>();

        for (BaseWatchedInterface la : content) {
            logger.info("Category {}", la.getCategory());
            logger.info("Category {}", la.getCounter());
        }

        for (BaseWatchedInterface baseWatchedInterface : content) {
            var previousValue = cateogiresAndCounter.get(baseWatchedInterface.getCategory());
            if (previousValue == null) previousValue = 0;
            cateogiresAndCounter.put(baseWatchedInterface.getCategory(), previousValue + baseWatchedInterface.getCounter());
        }

        List<Map.Entry<Category, Integer>> sortedCategories = new ArrayList<>(cateogiresAndCounter.entrySet());
        sortedCategories.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        logger.info("Sorted categories {}", sortedCategories);

        return sortedCategories.subList(0, max);
    }

    @Override
    public List<ProfileResource> toProfileResource(List<Profile> profiles) {
        List<ProfileResource> profileResources = new ArrayList<>();

        for (Profile profile : profiles) {
            profileResources.add(new ProfileResource(profile.getId(), profile.getName(), profile.getViewedMinutes()));
        }

        return profileResources;
    }
}
