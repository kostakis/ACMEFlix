package com.acmeflix.repository;

import com.acmeflix.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TvShowRepository extends JpaRepository<TvShow, Long> {

    List<TvShow> findBytvShowNameStartingWith(String initialTvShowName);

    TvShow findByTvShowName(String tvShowName);
}
