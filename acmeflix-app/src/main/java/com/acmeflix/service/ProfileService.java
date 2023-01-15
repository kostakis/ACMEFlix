package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.transfer.BaseWatchedInterface;
import com.acmeflix.transfer.KeyValue;
import com.acmeflix.transfer.MovieIdAndWatchedCounter;
import com.acmeflix.transfer.TvShowIdAndWatchedCounter;
import com.acmeflix.transfer.resource.AccountHistory;
import com.acmeflix.transfer.resource.BaseResource;
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

    List<BaseWatchedInterface> findTopSeriesAndMovies(int max);

    List<Map.Entry<Category, Integer>> findTopCategories(List<BaseWatchedInterface> content, int max);

}