package com.acmeflix.repository;

import com.acmeflix.domain.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TvShowRepository extends JpaRepository<TvShow, Long> {

}
