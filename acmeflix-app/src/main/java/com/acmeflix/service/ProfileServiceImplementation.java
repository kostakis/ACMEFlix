package com.acmeflix.service;

import com.acmeflix.domain.*;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.repository.ProfileRepository;
import com.acmeflix.transfer.BaseWatchedInterface;
import com.acmeflix.transfer.KeyValue;
import com.acmeflix.transfer.MovieIdAndWatchedCounter;
import com.acmeflix.transfer.TvShowIdAndWatchedCounter;
import com.acmeflix.transfer.resource.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

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
            Movie movie = movieService.find(movieId);
            movieDuration += movie.getDuration();
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

            var profiles = findByUserEager(user); //Get all the profiles

            AccountHistory accountHistory = new AccountHistory();
            accountHistory.setUser(user);

            List<ProfileResourceWithHistory> userProfiles = new ArrayList<>();

            for (Profile profile : profiles) { //For each profile of each user
                ProfileResourceWithHistory profileResourceWithHistory = new ProfileResourceWithHistory(profile.getId(), profile.getName(), profile.getViewedMinutes());

                List<MovieResource> movieResources = new ArrayList<>();
                List<TvShowResource> tvShowResources = new ArrayList<>();


                var watchedMovies = profile.getMovieHistory();
                for (Long movie : watchedMovies) { //Get all the watched movies
                    MovieResource movieResource = new MovieResource();
                    movieResource.setMovieName(movieService.get(movie).getMovieName());
                    movieResource.setId(movie);
                    movieResources.add(movieResource);
                }

                var watchedShows = profile.getTvShowHistory();
                for (Long showId : watchedShows) { //Get all the watched movies
                    TvShowResource tvShowResource = new TvShowResource();
                    tvShowResource.setTvShowName(tvShowService.get(showId).getTvShowName());
                    tvShowResource.setId(showId);
                    tvShowResources.add(tvShowResource);

                }

                profileResourceWithHistory.setMovieHistory(movieResources);
                profileResourceWithHistory.setTvHistory(tvShowResources);
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
        for (Profile profile : e) {
            Hibernate.initialize(profile.getMovieHistory());
            Hibernate.initialize(profile.getTvShowHistory());
        }

        return e;
    }

    @Override
    public List<MovieIdAndWatchedCounter> findTopTenMovies() {
        return profileRepository.findTopTenMovies();
    }

    @Override
    public List<TvShowIdAndWatchedCounter> findTopTenSeries() {
        return profileRepository.findTopTenSeries();
    }

    @Override
    public List<BaseWatchedInterface> findTopSeriesAndMovies(int max) {
        var movies = findTopTenMovies();
        var series = findTopTenSeries();

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

        for (BaseWatchedInterface baseWatchedInterface : content) {
            cateogiresAndCounter.merge(baseWatchedInterface.getCategory(), 1, Integer::sum);
        }

        logger.info("printing");
        cateogiresAndCounter.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        List<Map.Entry<Category, Integer>> nlist = new ArrayList<>(cateogiresAndCounter.entrySet());
        nlist.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        logger.info("lala {}", nlist);

        return nlist;
    }
}
