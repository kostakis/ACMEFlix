package com.acmeflix.service;

import com.acmeflix.domain.*;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.transfer.*;
import com.acmeflix.transfer.resource.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.*;

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
    public List<Profile> findByUser(@NonNull User user) {
        return profileRepository.findByUser(user);
    }

    @Override
    @Transactional
    public List<Profile> findByUserEager(@NonNull User user) {
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

            for (Profile profile : profiles) { //For each profile of each user
                List<MovieResource> movieResources = new ArrayList<>();
                List<TvShowResource> tvShowResources = new ArrayList<>();

                var watchedMovies = profile.getMovieHistory();
                for (Long movie : watchedMovies) { //Get all the watched movies
                    movieResources.add(MovieResource.builder()
                            .movieName(movieService.get(movie).getMovieName())
                            .id(movie)
                            .build());
                }

                var watchedShows = profile.getTvShowHistory();
                for (Long showId : watchedShows) { //Get all the watched tv shows
                    tvShowResources.add(TvShowResource.builder()
                            .tvShowName(tvShowService.get(showId).getTvShowName())
                            .id(showId)
                            .build());
                }

                userProfiles.add(ProfileResourceWithHistory.builder() //Create the history using all the above
                                .profileID(profile.getId())
                                .profileName(profile.getName())
                                .viewedMinutes(profile.getViewedMinutes())
                                .movieHistory(movieResources)
                                .tvHistory(tvShowResources)
                                .build());
            }

            accountHistoryList.add(AccountHistory.builder()
                    .user(user)
                    .profiles(userProfiles)
                    .build());
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
        var movies  = profileRepository.findTopRatedMovies(max);
        List<MovieRatedInterface> allRated = new ArrayList<>();
        allRated.addAll(movies);
        allRated = allRated.stream().sorted().limit(max).toList();

        return allRated;
    }

    @Override
    public List<TvShowRatedInterface> findTopRatedTvShows(int max) {
        var series  = profileRepository.findTopRatedTvShows(max);
        List<TvShowRatedInterface> allRated = new ArrayList<>();

        allRated.addAll(series);
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

        for(BaseWatchedInterface la: content) {
            logger.info("Category {}", la.getCategory());
            logger.info("Category {}", la.getCounter());
        }

        for (BaseWatchedInterface baseWatchedInterface : content) {
            var previousValue = cateogiresAndCounter.get(baseWatchedInterface.getCategory());
            if(previousValue == null) previousValue = 0;
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

        for(Profile profile: profiles) {
            profileResources.add(ProfileResource.builder()
                    .profileID(profile.getId())
                    .viewedMinutes(profile.getViewedMinutes())
                    .profileName(profile.getName())
                    .build());
        }

        return profileResources;
    }
}
