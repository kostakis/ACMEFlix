package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.Movie;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Profile("my-dev")
@RequiredArgsConstructor
@Order(2)
//Made this simple class to make sure domain/services/repository work as expected
//The rest of the generated data will be created at the import.sql
public class GenerateMovies extends AbstractLogComponent implements CommandLineRunner {

    private final MovieService movieService;


    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateMovies");

        var movies = movieService.createAll(
                Movie.builder().movieName("Titanic")
                        .category(Category.ROMANCE)
                        .description("Story about a love story")
                        .movieYear(1990)
                        .duration(120.5)
                        .rating(7.8f)
                        .build(),
                Movie.builder().movieName("Top Gun")
                        .category(Category.ACTION)
                        .description("I do not know")
                        .movieYear(1980)
                        .duration(89.0)
                        .rating(9f)
                        .build(),
                Movie.builder().movieName("How to train your dragon")
                        .category(Category.ANIMATION)
                        .description("Story about a kid and a dragon")
                        .movieYear(2015)
                        .duration(100.3)
                        .rating(7.4f)
                        .build(),
                Movie.builder().movieName("Toy Story 1")
                        .category(Category.ANIMATION)
                        .description("Story about toys")
                        .movieYear(2004)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                Movie.builder().movieName("Toy Story 2")
                        .category(Category.ANIMATION)
                        .description("Story about toys")
                        .movieYear(2008)
                        .duration(105.0)
                        .rating(8.5f)
                        .build(),
                Movie.builder().movieName("Toy Story 3")
                        .category(Category.ANIMATION)
                        .description("Story about toys")
                        .movieYear(20012)
                        .duration(110.0)
                        .rating(9f)
                        .build(),
                Movie.builder().movieName("Me before you")
                        .category(Category.DRAMA)
                        .description("Story about love")
                        .movieYear(2020)
                        .duration(85.0)
                        .rating(8.2f)
                        .build(),
                Movie.builder().movieName("Conjuring1")
                        .category(Category.HORROR)
                        .description("Scary")
                        .movieYear(2016)
                        .duration(85.5)
                        .rating(6.3f)
                        .build(),
                Movie.builder().movieName("Conjuring2")
                        .category(Category.HORROR)
                        .description("Scary")
                        .movieYear(2018)
                        .duration(80.2)
                        .rating(6.5f)
                        .build(),
                Movie.builder().movieName("Conjuring3")
                        .category(Category.HORROR)
                        .description("Scary")
                        .movieYear(2020)
                        .duration(90.0)
                        .rating(6.4f)
                        .build(),
                Movie.builder().movieName("Annabelle")
                        .category(Category.HORROR)
                        .description("Scary")
                        .movieYear(2022)
                        .duration(100.3)
                        .rating(6.2f)
                        .build(),
                Movie.builder().movieName("Mars")
                        .category(Category.SCIFI)
                        .description("Story about planets")
                        .movieYear(1950)
                        .duration(70.2)
                        .rating(5.4f)
                        .build(),
                Movie.builder().movieName("World War 2")
                        .category(Category.DOCUMENTARY)
                        .description("Story about War")
                        .movieYear(1990)
                        .duration(80.5)
                        .rating(8.3f)
                        .build(),
                Movie.builder().movieName("Cassiopia")
                        .category(Category.COMEDY)
                        .description("Story about a club")
                        .movieYear(2015)
                        .duration(89.2)
                        .rating(5.3f)
                        .build(),
                Movie.builder().movieName("Babylon")
                        .category(Category.DRAMA)
                        .description("Who cares")
                        .movieYear(2022)
                        .duration(110.1)
                        .rating(7.3f)
                        .build()
        );
    }
}
