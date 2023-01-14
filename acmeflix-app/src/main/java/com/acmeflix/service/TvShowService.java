package com.acmeflix.service;

import com.acmeflix.domain.TvShow;
public interface TvShowService extends BaseService<TvShow, Long> {


    TvShow findByTvShowName(String tvShowName);
}