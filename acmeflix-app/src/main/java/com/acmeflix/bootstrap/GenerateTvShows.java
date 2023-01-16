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
    private final TvShowService tvShowService2;

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

        TvShowEpisodes tvShowEpisodes3 = new TvShowEpisodes();
        tvShowEpisodes3.setEpisode(3);
        tvShowEpisodes3.setSeason(1);
        tvShowEpisodes3.setDuration(123);

        TvShowEpisodes tvShowEpisodes4 = new TvShowEpisodes();
        tvShowEpisodes4.setEpisode(1);
        tvShowEpisodes4.setSeason(2);
        tvShowEpisodes4.setDuration(123);

        TvShowEpisodes tvShowEpisodes5 = new TvShowEpisodes();
        tvShowEpisodes5.setEpisode(2);
        tvShowEpisodes5.setSeason(2);
        tvShowEpisodes5.setDuration(123);


        TvShow tvShow = new TvShow();
        tvShow.setTvShowName("Bing bang theory");
        tvShow.setTvShowYear(2008);
        tvShow.setCategory(Category.COMEDY);
        tvShow.setRating(9.0f);

        TvShowEpisodes tvShowEpisodes9 = new TvShowEpisodes();
        tvShowEpisodes9.setEpisode(1);
        tvShowEpisodes9.setSeason(1);
        tvShowEpisodes9.setDuration(75);

        TvShowEpisodes tvShowEpisodes8 = new TvShowEpisodes();
        tvShowEpisodes8.setEpisode(2);
        tvShowEpisodes8.setSeason(1);
        tvShowEpisodes8.setDuration(80);

        TvShowEpisodes tvShowEpisodes7 = new TvShowEpisodes();
        tvShowEpisodes7.setEpisode(1);
        tvShowEpisodes7.setSeason(2);
        tvShowEpisodes7.setDuration(80);

        TvShowEpisodes tvShowEpisodes6 = new TvShowEpisodes();
        tvShowEpisodes6.setEpisode(2);
        tvShowEpisodes6.setSeason(2);
        tvShowEpisodes6.setDuration(80);


        TvShow tvShow2 = new TvShow();
        tvShow2.setTvShowName("Gossip Girl");
        tvShow2.setTvShowYear(2000);
        tvShow2.setCategory(Category.DRAMA);
        tvShow2.setRating(10f);

        TvShowEpisodes tvShowEpisodes10 = new TvShowEpisodes();
        tvShowEpisodes10.setEpisode(3);
        tvShowEpisodes10.setSeason(1);
        tvShowEpisodes10.setDuration(60);

        TvShowEpisodes tvShowEpisodes11 = new TvShowEpisodes();
        tvShowEpisodes11.setEpisode(2);
        tvShowEpisodes11.setSeason(1);
        tvShowEpisodes11.setDuration(64);

        TvShowEpisodes tvShowEpisodes12 = new TvShowEpisodes();
        tvShowEpisodes12.setEpisode(1);
        tvShowEpisodes12.setSeason(1);
        tvShowEpisodes12.setDuration(62);


        TvShow tvShow3 = new TvShow();
        tvShow3.setTvShowName("Ginny And Georgia");
        tvShow3.setTvShowYear(2022);
        tvShow3.setCategory(Category.ROMANCE);
        tvShow3.setRating(8.2f);


        TvShowEpisodes tvShowEpisodes19 = new TvShowEpisodes();
        tvShowEpisodes19.setEpisode(3);
        tvShowEpisodes19.setSeason(2);
        tvShowEpisodes19.setDuration(60);

        TvShowEpisodes tvShowEpisodes18 = new TvShowEpisodes();
        tvShowEpisodes18.setEpisode(2);
        tvShowEpisodes18.setSeason(2);
        tvShowEpisodes18.setDuration(60);

        TvShowEpisodes tvShowEpisodes17 = new TvShowEpisodes();
        tvShowEpisodes17.setEpisode(1);
        tvShowEpisodes17.setSeason(2);
        tvShowEpisodes17.setDuration(60);

        TvShowEpisodes tvShowEpisodes16 = new TvShowEpisodes();
        tvShowEpisodes16.setEpisode(34);
        tvShowEpisodes16.setSeason(1);
        tvShowEpisodes16.setDuration(60);

        TvShowEpisodes tvShowEpisodes15 = new TvShowEpisodes();
        tvShowEpisodes15.setEpisode(3);
        tvShowEpisodes15.setSeason(1);
        tvShowEpisodes15.setDuration(60);

        TvShowEpisodes tvShowEpisodes14 = new TvShowEpisodes();
        tvShowEpisodes14.setEpisode(2);
        tvShowEpisodes14.setSeason(1);
        tvShowEpisodes14.setDuration(64);

        TvShowEpisodes tvShowEpisodes13 = new TvShowEpisodes();
        tvShowEpisodes13.setEpisode(1);
        tvShowEpisodes13.setSeason(1);
        tvShowEpisodes13.setDuration(62);


        TvShow tvShow4 = new TvShow();
        tvShow4.setTvShowName("Rick and Morty");
        tvShow4.setTvShowYear(2000);
        tvShow4.setCategory(Category.ANIMATION);
        tvShow4.setRating(9.9f);


        tvShow.setEpisode(List.of(tvShowEpisodes,tvShowEpisodes2,tvShowEpisodes3,tvShowEpisodes4,tvShowEpisodes5));
        tvShow2.setEpisode(List.of(tvShowEpisodes6,tvShowEpisodes7,tvShowEpisodes8,tvShowEpisodes9));
        tvShow3.setEpisode(List.of(tvShowEpisodes10,tvShowEpisodes11,tvShowEpisodes12));
        tvShow4.setEpisode(List.of(tvShowEpisodes13,tvShowEpisodes14,tvShowEpisodes16,tvShowEpisodes17,tvShowEpisodes18,tvShowEpisodes19));

        tvShowService.create(tvShow);
//        tvShowService2.create(tvShow2);

    }
}
