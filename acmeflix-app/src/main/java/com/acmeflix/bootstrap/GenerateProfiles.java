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
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;

@Component
@Profile("my-dev")
@RequiredArgsConstructor
@Order(3)
public class GenerateProfiles extends AbstractLogComponent implements CommandLineRunner {

    @NotNull
    private final ProfileService profileService;
    @NotNull
    private final UserService userService;
    @NotNull
    private final MovieService movieService;
    @NotNull
    private final TvShowService tvShowService;

    @Override
    public void run(String... args) throws Exception {
        var allusers = userService.findAll();


        var allMovies = movieService.findAll();
        //var allSeries = tvShowService.findAll();

        Long minMovieId = allMovies.get(0).getId();
        Long maxMovieId = allMovies.get(allMovies.size() - 1).getId();

        //Creating profiles for each users
        for(User user: allusers) {
            com.acmeflix.domain.Profile profile = new com.acmeflix.domain.Profile();
            profile.setUser(user);
            profile.setName("myprofile1");

            Long myRandom = (long) ((Math.random() * (maxMovieId - minMovieId)) + minMovieId);
            Long myRandom1 = (long) ((Math.random() * (maxMovieId - minMovieId)) + minMovieId);
            Long myRandom2 = (long) ((Math.random() * (maxMovieId - minMovieId)) + minMovieId);

            profile.setMovieHistory(List.of(myRandom, myRandom1, myRandom2));

            profileService.createUsingHistory(profile);
        }

        //Second profile
        com.acmeflix.domain.Profile profile = new com.acmeflix.domain.Profile();
        profile.setUser(userService.find(1L));
        profile.setName("myprofile2");
        Long myRandom = (long) ((Math.random() * (maxMovieId - minMovieId)) + minMovieId);
        Long myRandom1 = (long) ((Math.random() * (maxMovieId - minMovieId)) + minMovieId);
        profile.setMovieHistory(List.of(myRandom, myRandom1));

        profileService.createUsingHistory(profile);
    }
}
