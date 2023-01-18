package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.User;
import com.acmeflix.service.MovieService;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.TvShowService;
import com.acmeflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Random;

@Component
@Profile("my-dev")
@RequiredArgsConstructor
@Order(4)
public class GenerateProfiles extends AbstractLogComponent implements CommandLineRunner {

    @NotNull
    private final ProfileService profileService;
    @NotNull
    private final UserService userService;
    @NotNull
    private final MovieService movieService;
    @NotNull
    private final TvShowService tvShowService;

    Random randomGenerator = new Random();

    private Long getRandom(List<Long> list) {
        return list.get(randomGenerator.nextInt(list.size()));
    }

    @Override
    public void run(String... args) throws Exception {
        var allusers = userService.findAll();

        var allMovies = movieService.getAllIds();
        var allSeries = tvShowService.getAllIds();

        //Creating 2 profiles for each user
        for(User user: allusers) {
            com.acmeflix.domain.Profile profile = new com.acmeflix.domain.Profile();
            profile.setUser(user);
            profile.setName("myprofile1");

            profile.setMovieHistory(List.of(getRandom(allMovies),
                                            getRandom(allMovies),
                                            getRandom(allMovies)));

            profile.setTvShowHistory(List.of(getRandom(allSeries),
                    getRandom(allSeries)));

            profileService.createUsingHistory(profile);


            com.acmeflix.domain.Profile profile2 = new com.acmeflix.domain.Profile();
            profile2.setUser(user);
            profile2.setName("myprofile2");

            profile2.setMovieHistory(List.of(getRandom(allMovies),
                    getRandom(allMovies),
                    getRandom(allMovies)));

            profile2.setTvShowHistory(List.of(getRandom(allSeries),
                    getRandom(allSeries)));

            profileService.createUsingHistory(profile2);
        }
    }
}
