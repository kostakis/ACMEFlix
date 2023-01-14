package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {


//    @Query("Select m from Movie m where m.movieName like %:name%")
//    Optional<List<Movie>> getMoviesByInitialName(String name);


    List<Movie> findBymovieNameStartingWith(String initialMovieName);

    Movie findByMovieName(String movieName);
}
