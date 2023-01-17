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

        TvShowEpisodes tvShowEpisodes21 = new TvShowEpisodes();
        tvShowEpisodes21.setEpisode(1);
        tvShowEpisodes21.setSeason(1);
        tvShowEpisodes21.setDuration(60);

        TvShowEpisodes tvShowEpisodes22 = new TvShowEpisodes();
        tvShowEpisodes22.setEpisode(2);
        tvShowEpisodes22.setSeason(1);
        tvShowEpisodes22.setDuration(60);

        TvShowEpisodes tvShowEpisodes23 = new TvShowEpisodes();
        tvShowEpisodes23.setEpisode(3);
        tvShowEpisodes23.setSeason(1);
        tvShowEpisodes23.setDuration(60);

        TvShowEpisodes tvShowEpisodes24 = new TvShowEpisodes();
        tvShowEpisodes24.setEpisode(4);
        tvShowEpisodes24.setSeason(1);
        tvShowEpisodes24.setDuration(60);

        TvShowEpisodes tvShowEpisodes25 = new TvShowEpisodes();
        tvShowEpisodes25.setEpisode(5);
        tvShowEpisodes25.setSeason(1);
        tvShowEpisodes25.setDuration(60);

        TvShow tvShow5 = new TvShow();
        tvShow5.setTvShowName("Kaleidoscope");
        tvShow5.setTvShowYear(2022);
        tvShow5.setCategory(Category.ACTION);
        tvShow5.setRating(7.4f);

        TvShowEpisodes tvShowEpisodes28 = new TvShowEpisodes();
        tvShowEpisodes28.setEpisode(1);
        tvShowEpisodes28.setSeason(1);
        tvShowEpisodes28.setDuration(60);

        TvShowEpisodes tvShowEpisodes29 = new TvShowEpisodes();
        tvShowEpisodes29.setEpisode(2);
        tvShowEpisodes29.setSeason(1);
        tvShowEpisodes29.setDuration(60);

        TvShowEpisodes tvShowEpisodes30 = new TvShowEpisodes();
        tvShowEpisodes30.setEpisode(3);
        tvShowEpisodes30.setSeason(1);
        tvShowEpisodes30.setDuration(60);

        TvShowEpisodes tvShowEpisodes31 = new TvShowEpisodes();
        tvShowEpisodes31.setEpisode(4);
        tvShowEpisodes31.setSeason(1);
        tvShowEpisodes31.setDuration(60);

        TvShowEpisodes tvShowEpisodes34 = new TvShowEpisodes();
        tvShowEpisodes34.setEpisode(5);
        tvShowEpisodes34.setSeason(1);
        tvShowEpisodes34.setDuration(60);

        TvShow tvShow6 = new TvShow();
        tvShow6.setTvShowName("CHICAGO MD");
        tvShow6.setTvShowYear(2015);
        tvShow6.setCategory(Category.ACTION);
        tvShow6.setRating(7.1f);


        TvShowEpisodes tvShowEpisodes44 = new TvShowEpisodes();
        tvShowEpisodes44.setEpisode(1);
        tvShowEpisodes44.setSeason(1);
        tvShowEpisodes44.setDuration(60);

        TvShowEpisodes tvShowEpisodes45 = new TvShowEpisodes();
        tvShowEpisodes45.setEpisode(2);
        tvShowEpisodes45.setSeason(1);
        tvShowEpisodes45.setDuration(60);

        TvShowEpisodes tvShowEpisodes46 = new TvShowEpisodes();
        tvShowEpisodes46.setEpisode(3);
        tvShowEpisodes46.setSeason(1);
        tvShowEpisodes46.setDuration(60);

        TvShowEpisodes tvShowEpisodes47 = new TvShowEpisodes();
        tvShowEpisodes47.setEpisode(4);
        tvShowEpisodes47.setSeason(1);
        tvShowEpisodes47.setDuration(60);

        TvShowEpisodes tvShowEpisodes48 = new TvShowEpisodes();
        tvShowEpisodes48.setEpisode(5);
        tvShowEpisodes48.setSeason(1);
        tvShowEpisodes48.setDuration(60);

        TvShow tvShow7 = new TvShow();
        tvShow7.setTvShowName("Vikings Valhalla");
        tvShow7.setTvShowYear(2021);
        tvShow7.setCategory(Category.ACTION);
        tvShow7.setRating(9.8f);

        TvShowEpisodes tvShowEpisodes49 = new TvShowEpisodes();
        tvShowEpisodes49.setEpisode(1);
        tvShowEpisodes49.setSeason(1);
        tvShowEpisodes49.setDuration(60);

        TvShowEpisodes tvShowEpisodes50 = new TvShowEpisodes();
        tvShowEpisodes50.setEpisode(2);
        tvShowEpisodes50.setSeason(1);
        tvShowEpisodes50.setDuration(60);

        TvShowEpisodes tvShowEpisodes51 = new TvShowEpisodes();
        tvShowEpisodes51.setEpisode(3);
        tvShowEpisodes51.setSeason(1);
        tvShowEpisodes51.setDuration(60);

        TvShowEpisodes tvShowEpisodes52 = new TvShowEpisodes();
        tvShowEpisodes52.setEpisode(4);
        tvShowEpisodes52.setSeason(1);
        tvShowEpisodes52.setDuration(60);

        TvShowEpisodes tvShowEpisodes53 = new TvShowEpisodes();
        tvShowEpisodes53.setEpisode(5);
        tvShowEpisodes53.setSeason(1);
        tvShowEpisodes53.setDuration(60);

        TvShow tvShow8 = new TvShow();
        tvShow8.setTvShowName("Star Wars: The Bad Batch");
        tvShow8.setTvShowYear(2020);
        tvShow8.setCategory(Category.ANIMATION);
        tvShow8.setRating(5.1f);

        TvShowEpisodes tvShowEpisodes54 = new TvShowEpisodes();
        tvShowEpisodes54.setEpisode(1);
        tvShowEpisodes54.setSeason(1);
        tvShowEpisodes54.setDuration(60);

        TvShowEpisodes tvShowEpisodes55 = new TvShowEpisodes();
        tvShowEpisodes55.setEpisode(2);
        tvShowEpisodes55.setSeason(1);
        tvShowEpisodes55.setDuration(60);

        TvShowEpisodes tvShowEpisodes56 = new TvShowEpisodes();
        tvShowEpisodes56.setEpisode(3);
        tvShowEpisodes56.setSeason(1);
        tvShowEpisodes56.setDuration(60);

        TvShowEpisodes tvShowEpisodes57 = new TvShowEpisodes();
        tvShowEpisodes57.setEpisode(4);
        tvShowEpisodes57.setSeason(1);
        tvShowEpisodes57.setDuration(60);

        TvShowEpisodes tvShowEpisodes58 = new TvShowEpisodes();
        tvShowEpisodes58.setEpisode(5);
        tvShowEpisodes58.setSeason(1);
        tvShowEpisodes58.setDuration(60);

        TvShow tvShow9 = new TvShow();
        tvShow9.setTvShowName("CHICAGO PD");
        tvShow9.setTvShowYear(2014);
        tvShow9.setCategory(Category.ACTION);
        tvShow9.setRating(8.1f);

        TvShowEpisodes tvShowEpisodes59 = new TvShowEpisodes();
        tvShowEpisodes59.setEpisode(1);
        tvShowEpisodes59.setSeason(1);
        tvShowEpisodes59.setDuration(60);

        TvShowEpisodes tvShowEpisodes60 = new TvShowEpisodes();
        tvShowEpisodes60.setEpisode(2);
        tvShowEpisodes60.setSeason(1);
        tvShowEpisodes60.setDuration(60);

        TvShowEpisodes tvShowEpisodes61 = new TvShowEpisodes();
        tvShowEpisodes61.setEpisode(3);
        tvShowEpisodes61.setSeason(1);
        tvShowEpisodes61.setDuration(60);

        TvShowEpisodes tvShowEpisodes62 = new TvShowEpisodes();
        tvShowEpisodes62.setEpisode(4);
        tvShowEpisodes62.setSeason(1);
        tvShowEpisodes62.setDuration(60);

        TvShowEpisodes tvShowEpisodes63 = new TvShowEpisodes();
        tvShowEpisodes63.setEpisode(5);
        tvShowEpisodes63.setSeason(1);
        tvShowEpisodes63.setDuration(60);

        TvShow tvShow10 = new TvShow();
        tvShow10.setTvShowName("CHICAGO FIRE");
        tvShow10.setTvShowYear(2015);
        tvShow10.setCategory(Category.ACTION);
        tvShow10.setRating(7.8f);

        TvShowEpisodes tvShowEpisodes64 = new TvShowEpisodes();
        tvShowEpisodes64.setEpisode(1);
        tvShowEpisodes64.setSeason(1);
        tvShowEpisodes64.setDuration(60);

        TvShowEpisodes tvShowEpisodes65 = new TvShowEpisodes();
        tvShowEpisodes65.setEpisode(2);
        tvShowEpisodes65.setSeason(1);
        tvShowEpisodes65.setDuration(60);

        TvShowEpisodes tvShowEpisodes66 = new TvShowEpisodes();
        tvShowEpisodes66.setEpisode(3);
        tvShowEpisodes66.setSeason(1);
        tvShowEpisodes66.setDuration(60);

        TvShowEpisodes tvShowEpisodes67 = new TvShowEpisodes();
        tvShowEpisodes67.setEpisode(4);
        tvShowEpisodes67.setSeason(1);
        tvShowEpisodes67.setDuration(60);

        TvShowEpisodes tvShowEpisodes68 = new TvShowEpisodes();
        tvShowEpisodes68.setEpisode(5);
        tvShowEpisodes68.setSeason(1);
        tvShowEpisodes68.setDuration(60);

        TvShow tvShow11 = new TvShow();
        tvShow11.setTvShowName("Seinfeld");
        tvShow11.setTvShowYear(1996);
        tvShow11.setCategory(Category.COMEDY);
        tvShow11.setRating(5.8f);

        TvShowEpisodes tvShowEpisodes69 = new TvShowEpisodes();
        tvShowEpisodes69.setEpisode(1);
        tvShowEpisodes69.setSeason(1);
        tvShowEpisodes69.setDuration(60);

        TvShowEpisodes tvShowEpisodes70 = new TvShowEpisodes();
        tvShowEpisodes70.setEpisode(2);
        tvShowEpisodes70.setSeason(1);
        tvShowEpisodes70.setDuration(60);

        TvShowEpisodes tvShowEpisode74 = new TvShowEpisodes();
        tvShowEpisode74.setEpisode(3);
        tvShowEpisode74.setSeason(1);
        tvShowEpisode74.setDuration(60);

        TvShowEpisodes tvShowEpisodes72 = new TvShowEpisodes();
        tvShowEpisodes72.setEpisode(4);
        tvShowEpisodes72.setSeason(1);
        tvShowEpisodes72.setDuration(60);

        TvShowEpisodes tvShowEpisodes73 = new TvShowEpisodes();
        tvShowEpisodes73.setEpisode(5);
        tvShowEpisodes73.setSeason(1);
        tvShowEpisodes73.setDuration(60);

        TvShow tvShow12 = new TvShow();
        tvShow12.setTvShowName("Law & Order: Organized Crime");
        tvShow12.setTvShowYear(2021);
        tvShow12.setCategory(Category.DRAMA);
        tvShow12.setRating(7.1f);

        TvShowEpisodes tvShowEpisodes75 = new TvShowEpisodes();
        tvShowEpisodes75.setEpisode(1);
        tvShowEpisodes75.setSeason(1);
        tvShowEpisodes75.setDuration(60);

        TvShowEpisodes tvShowEpisodes76 = new TvShowEpisodes();
        tvShowEpisodes76.setEpisode(2);
        tvShowEpisodes76.setSeason(1);
        tvShowEpisodes76.setDuration(60);

        TvShowEpisodes tvShowEpisode77 = new TvShowEpisodes();
        tvShowEpisode77.setEpisode(3);
        tvShowEpisode77.setSeason(1);
        tvShowEpisode77.setDuration(60);

        TvShowEpisodes tvShowEpisodes78 = new TvShowEpisodes();
        tvShowEpisodes78.setEpisode(4);
        tvShowEpisodes78.setSeason(1);
        tvShowEpisodes78.setDuration(60);

        TvShowEpisodes tvShowEpisodes79 = new TvShowEpisodes();
        tvShowEpisodes79.setEpisode(5);
        tvShowEpisodes79.setSeason(1);
        tvShowEpisodes79.setDuration(60);

        TvShow tvShow13 = new TvShow();
        tvShow13.setTvShowName("The Rig");
        tvShow13.setTvShowYear(2022);
        tvShow13.setCategory(Category.DRAMA);
        tvShow13.setRating(5.3f);

        TvShowEpisodes tvShowEpisodes80 = new TvShowEpisodes();
        tvShowEpisodes80.setEpisode(1);
        tvShowEpisodes80.setSeason(1);
        tvShowEpisodes80.setDuration(60);

        TvShowEpisodes tvShowEpisodes81 = new TvShowEpisodes();
        tvShowEpisodes81.setEpisode(2);
        tvShowEpisodes81.setSeason(1);
        tvShowEpisodes81.setDuration(60);

        TvShowEpisodes tvShowEpisode82 = new TvShowEpisodes();
        tvShowEpisode82.setEpisode(3);
        tvShowEpisode82.setSeason(1);
        tvShowEpisode82.setDuration(60);

        TvShowEpisodes tvShowEpisodes83 = new TvShowEpisodes();
        tvShowEpisodes83.setEpisode(4);
        tvShowEpisodes83.setSeason(1);
        tvShowEpisodes83.setDuration(60);

        TvShowEpisodes tvShowEpisodes84 = new TvShowEpisodes();
        tvShowEpisodes84.setEpisode(5);
        tvShowEpisodes84.setSeason(1);
        tvShowEpisodes84.setDuration(60);

        TvShow tvShow14 = new TvShow();
        tvShow14.setTvShowName("Kingdom");
        tvShow14.setTvShowYear(2016);
        tvShow14.setCategory(Category.DRAMA);
        tvShow14.setRating(8.7f);

        TvShowEpisodes tvShowEpisodes85 = new TvShowEpisodes();
        tvShowEpisodes85.setEpisode(1);
        tvShowEpisodes85.setSeason(1);
        tvShowEpisodes85.setDuration(60);

        TvShowEpisodes tvShowEpisodes86 = new TvShowEpisodes();
        tvShowEpisodes86.setEpisode(2);
        tvShowEpisodes86.setSeason(1);
        tvShowEpisodes86.setDuration(60);

        TvShowEpisodes tvShowEpisode87 = new TvShowEpisodes();
        tvShowEpisode87.setEpisode(3);
        tvShowEpisode87.setSeason(1);
        tvShowEpisode87.setDuration(60);

        TvShowEpisodes tvShowEpisodes88 = new TvShowEpisodes();
        tvShowEpisodes88.setEpisode(4);
        tvShowEpisodes88.setSeason(1);
        tvShowEpisodes88.setDuration(60);

        TvShowEpisodes tvShowEpisodes89 = new TvShowEpisodes();
        tvShowEpisodes89.setEpisode(5);
        tvShowEpisodes89.setSeason(1);
        tvShowEpisodes89.setDuration(60);

        TvShow tvShow15 = new TvShow();
        tvShow15.setTvShowName("Anne Rice's Mayfair Witches");
        tvShow15.setTvShowYear(2023);
        tvShow15.setCategory(Category.HORROR);
        tvShow15.setRating(6.1f);



        tvShow.setEpisode(List.of(tvShowEpisodes,tvShowEpisodes2,tvShowEpisodes3,tvShowEpisodes4,tvShowEpisodes5));
        tvShow2.setEpisode(List.of(tvShowEpisodes6,tvShowEpisodes7,tvShowEpisodes8,tvShowEpisodes9));
        tvShow3.setEpisode(List.of(tvShowEpisodes10,tvShowEpisodes11,tvShowEpisodes12));
        tvShow4.setEpisode(List.of(tvShowEpisodes13,tvShowEpisodes14,tvShowEpisodes16,tvShowEpisodes17,tvShowEpisodes18,tvShowEpisodes19));
        tvShow5.setEpisode(List.of(tvShowEpisodes21,tvShowEpisodes22,tvShowEpisodes23,tvShowEpisodes24,tvShowEpisodes25));
        tvShow6.setEpisode(List.of(tvShowEpisodes28,tvShowEpisodes29,tvShowEpisodes30,tvShowEpisodes31,tvShowEpisodes34));
        tvShow7.setEpisode(List.of(tvShowEpisodes44,tvShowEpisodes45,tvShowEpisodes46,tvShowEpisodes47,tvShowEpisodes48));
        tvShow8.setEpisode(List.of(tvShowEpisodes49,tvShowEpisodes50,tvShowEpisodes51,tvShowEpisodes52,tvShowEpisodes53));
        tvShow9.setEpisode(List.of(tvShowEpisodes54,tvShowEpisodes55,tvShowEpisodes56,tvShowEpisodes57,tvShowEpisodes58));
        tvShow10.setEpisode(List.of(tvShowEpisodes59,tvShowEpisodes60,tvShowEpisodes61,tvShowEpisodes62,tvShowEpisodes63));
        tvShow11.setEpisode(List.of(tvShowEpisodes64,tvShowEpisodes65,tvShowEpisodes66,tvShowEpisodes67,tvShowEpisodes68));
        tvShow12.setEpisode(List.of(tvShowEpisodes69,tvShowEpisodes70,tvShowEpisode74,tvShowEpisodes72,tvShowEpisodes73));
        tvShow13.setEpisode(List.of(tvShowEpisodes75,tvShowEpisodes76,tvShowEpisode77,tvShowEpisodes78,tvShowEpisodes79));
        tvShow14.setEpisode(List.of(tvShowEpisodes80,tvShowEpisodes81,tvShowEpisode82,tvShowEpisodes83,tvShowEpisodes84));
        tvShow15.setEpisode(List.of(tvShowEpisodes85,tvShowEpisodes86,tvShowEpisode87,tvShowEpisodes88,tvShowEpisodes89));


        tvShowService.createAll(List.of(tvShow,tvShow2,tvShow3, tvShow4, tvShow5, tvShow6,tvShow7, tvShow8, tvShow9, tvShow10,
                tvShow11, tvShow12, tvShow13,tvShow14,tvShow15));
    }
}
