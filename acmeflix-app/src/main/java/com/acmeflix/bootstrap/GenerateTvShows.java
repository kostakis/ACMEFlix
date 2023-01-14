package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.TvShow;
import com.acmeflix.domain.TvShowEpisodes;
import com.acmeflix.service.TvShowService;
import com.acmeflix.domain.enumeration.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("my-dev")
@RequiredArgsConstructor
@Order(2)
//Made this simple class to make sure domain/services/repository work as expected
//The rest of the generated data will be created at the import.sql
public class GenerateTvShows extends AbstractLogComponent implements CommandLineRunner {

    private final TvShowService tvShowService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateTvShows");

        TvShowEpisodes tvShowEpisodes = new TvShowEpisodes();
        tvShowEpisodes.setEpisode(1);
        tvShowEpisodes.setSeason(1);
        tvShowEpisodes.setDuration(123);


        TvShowEpisodes tvShowEpisodes2 = new TvShowEpisodes();
        tvShowEpisodes2.setEpisode(2);
        tvShowEpisodes2.setSeason(1);
        tvShowEpisodes2.setDuration(123);

        TvShow tvShow = new TvShow();
        tvShow.setTvShowName("Bing bang theory");
        tvShow.setTvShowYear(2008);
        tvShow.setCategory(Category.DRAMA);
        tvShow.setRating(9.0f);

        tvShow.setTvShowSeasons(List.of(tvShowEpisodes, tvShowEpisodes2));

        tvShowService.create(tvShow);

    }
}
