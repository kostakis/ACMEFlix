package com.acmeflix.service;

import com.acmeflix.domain.TvShow;

import java.util.List;

public interface TvShowService extends BaseService<TvShow, Long> {

    List<TvShow> findByInitialTvShowName(String initialTvShowName);

    TvShow findByTvShowName(String tvShowName);

    List<Long> getAllIds();
}