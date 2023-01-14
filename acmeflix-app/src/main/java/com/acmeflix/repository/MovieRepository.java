package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByMovieName(String movieName);
}
