package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findBymovieNameStartingWith(String initialMovieName);

    Movie findByMovieName(String movieName);
}
