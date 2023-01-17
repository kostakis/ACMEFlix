package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.transfer.*;
import com.acmeflix.transfer.resource.AccountHistory;
import com.acmeflix.transfer.resource.BaseResource;
import com.acmeflix.transfer.resource.ProfileResource;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProfileService extends BaseService<Profile, Long> {

    Profile createUsingHistory(Profile profile);

    List<Profile> findByUser(User user);

    public List<Profile> findByUserEager(User user);

    List<AccountHistory> mapToAccountHistory(List<Long> allUserIds);

    List<Profile> findAllEager();

    List<MovieIdAndWatchedCounter> findTopMovies(int max);

    List<TvShowIdAndWatchedCounter> findTopSeries(int max);

    List<MovieRatedInterface> findTopRatedMovies(int max);
    
    List<TvShowRatedInterface> findTopRatedTvShows(int max);

    List<BaseWatchedInterface> findTopSeriesAndMovies(int max);

    List<Map.Entry<Category, Integer>> findTopCategories(List<BaseWatchedInterface> content, int max);

    List<ProfileResource> toProfileResource(List<Profile> profiles);
}