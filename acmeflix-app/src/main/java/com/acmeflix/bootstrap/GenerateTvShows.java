package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.TvShow;
import com.acmeflix.service.TvShowService;
import com.acmeflix.domain.enumeration.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("my-dev")
@RequiredArgsConstructor
//Made this simple class to make sure domain/services/repository work as expected
//The rest of the generated data will be created at the import.sql
public class GenerateTvShows extends AbstractLogComponent implements CommandLineRunner {

    private final TvShowService tvShowService;


    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateTvShows");

        var tvShows = tvShowService.createAll(
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(1)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(2)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(115.7)
                        .rating(7.5f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(3)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(100.0)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(4)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(5)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(6)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(7)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(8)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(9)
                        .season(1)
                        .tvShowYear(2019)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(1)
                        .season(2)
                        .tvShowYear(2020)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(2)
                        .season(2)
                        .tvShowYear(2020)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(3)
                        .season(2)
                        .tvShowYear(2020)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(4)
                        .season(2)
                        .tvShowYear(2020)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Gossip Girl")
                        .category(Category.ROMANCE)
                        .description("xoxo GG")
                        .episode(5)
                        .season(2)
                        .tvShowYear(2020)
                        .duration(120.7)
                        .rating(3.2f)
                        .build(),
                TvShow.builder().tvShowName("Spy House")
                        .category(Category.ACTION)
                        .description("I do not know")
                        .episode(6)
                        .season(1)
                        .tvShowYear(1985)
                        .duration(85.0)
                        .rating(6.2f)
                        .build(),
                TvShow.builder().tvShowName("Spy House")
                        .category(Category.ACTION)
                        .description("I do not know")
                        .episode(1)
                        .season(1)
                        .tvShowYear(1985)
                        .duration(85.0)
                        .rating(6.2f)
                        .build(),
                TvShow.builder().tvShowName("Spy House")
                        .category(Category.ACTION)
                        .description("I do not know")
                        .episode(2)
                        .season(1)
                        .tvShowYear(1985)
                        .duration(85.0)
                        .rating(6.2f)
                        .build(),
                TvShow.builder().tvShowName("Spy House")
                        .category(Category.ACTION)
                        .description("I do not know")
                        .episode(3)
                        .season(1)
                        .tvShowYear(1985)
                        .duration(85.0)
                        .rating(6.2f)
                        .build(),
                TvShow.builder().tvShowName("Spy House")
                        .category(Category.ACTION)
                        .description("I do not know")
                        .episode(4)
                        .season(1)
                        .tvShowYear(1985)
                        .duration(85.0)
                        .rating(6.2f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(1)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(2)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(3)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(4)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(5)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(6)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(7)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(8)
                        .season(1)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(1)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(2)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(3)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(4)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(5)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(6)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Big Bang Theory")
                        .category(Category.COMEDY)
                        .description("Story about Sheldon")
                        .episode(7)
                        .season(2)
                        .tvShowYear(2000)
                        .duration(105.3)
                        .rating(10f)
                        .build(),
                    TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(1)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(2)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(3)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(4)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(5)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(6)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Rich and Morty")
                        .category(Category.ANIMATION)
                        .description("Story about friendship")
                        .tvShowYear(2002)
                        .episode(7)
                        .season(1)
                        .duration(118.4)
                        .rating(9.3f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(1)
                        .season(1)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(2)
                        .season(1)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(3)
                        .season(1)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(4)
                        .season(1)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(5)
                        .season(1)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(1)
                        .season(2)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(2)
                        .season(2)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(3)
                        .season(2)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(4)
                        .season(2)
                        .duration(115.5)
                        .rating(10f)
                        .build(),
                TvShow.builder().tvShowName("Friends")
                        .category(Category.COMEDY)
                        .description("Story about friendship vol2")
                        .tvShowYear(1998)
                        .episode(5)
                        .season(2)
                        .duration(115.5)
                        .rating(10f)
                        .build()
        );

        TvShow tvShow = tvShowService.findByTvShowName("Ginny and Georgia");
        //Just testing
        if(tvShow == null) {
            logger.info("Ok it is null");
            return;
        }
        tvShow.setTvShowName("Ginny and Georgia 2");

        tvShowService.update(tvShow);

        logger.info("Created Movies {}", tvShows);
    }
}
