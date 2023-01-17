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
@Order(3)
public class GenerateMovies extends AbstractLogComponent implements CommandLineRunner {

    private final MovieService movieService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateMovies");

        var movies = movieService.createAll(
                Movie.builder().movieName("Titanic")
                        .category(Category.ROMANCE)
                        .description("A seventeen-year-old aristocrat falls in love with a kind but poor " +
                                "artist aboard the luxurious, ill-fated R.M.S. Titanic.")
                        .movieYear(1997)
                        .duration(120)
                        .rating(7.9f)
                        .build(),
                Movie.builder().movieName("Top Gun")
                        .category(Category.ACTION)
                        .description("As students at the United States Navy's elite fighter weapons school compete to " +
                                "be best in the class, one daring young pilot learns a few things from a civilian " +
                                "instructor that are not taught in the classroom.")
                        .movieYear(1986)
                        .duration(125)
                        .rating(6.9f)
                        .build(),
                Movie.builder().movieName("How to train your dragon")
                        .category(Category.ANIMATION)
                        .description("A hapless young Viking who aspires to hunt dragons becomes the unlikely " +
                                "friend of a young dragon himself, and learns there may be more to the creatures than he assumed.")
                        .movieYear(2010)
                        .duration(100)
                        .rating(8.1f)
                        .build(),
                Movie.builder().movieName("Toy Story ")
                        .category(Category.ANIMATION)
                        .description("A cowboy doll is profoundly threatened and jealous when a new spaceman" +
                                " action figure supplants him as top toy in a boy's bedroom.")
                        .movieYear(1995)
                        .duration(88)
                        .rating(9.3f)
                        .build(),
                Movie.builder().movieName("Toy Story 2")
                        .category(Category.ANIMATION)
                        .description("When Woody is stolen by a toy collector, Buzz and his friends set out on a rescue mission to " +
                                "save Woody before he becomes a museum toy property with his roundup gang Jessie, Prospector, and Bullseye.")
                        .movieYear(1999)
                        .duration(105)
                        .rating(8.5f)
                        .build(),
                Movie.builder().movieName("Toy Story 3")
                        .category(Category.ANIMATION)
                        .description("The toys are mistakenly delivered to a day-care center instead of the attic right before Andy leaves for college, " +
                                "and it's up to Woody to convince the other toys that they weren't abandoned and to return home.")
                        .movieYear(2010)
                        .duration(110)
                        .rating(9f)
                        .build(),
                Movie.builder().movieName("Me before you")
                        .category(Category.DRAMA)
                        .description("A girl in a small town forms an unlikely bond with a recently-paralyzed man she's taking care of.")
                        .movieYear(2016)
                        .duration(95)
                        .rating(7.4f)
                        .build(),
                Movie.builder().movieName(" The Conjuring")
                        .category(Category.HORROR)
                        .description("Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.")
                        .movieYear(2013)
                        .duration(85)
                        .rating(6.3f)
                        .build(),
                Movie.builder().movieName("Conjuring 2")
                        .category(Category.HORROR)
                        .description("Ed and Lorraine Warren travel to North London to help a single mother raising " +
                                "four children alone in a house plagued by a supernatural spirit.")
                        .movieYear(2018)
                        .duration(80)
                        .rating(6.5f)
                        .build(),
                Movie.builder().movieName("The Conjuring: The Devil Made Me Do It")
                        .category(Category.HORROR)
                        .description("The Warrens investigate a murder that may be linked to a demonic possession.")
                        .movieYear(2021)
                        .duration(90)
                        .rating(7.4f)
                        .build(),
                Movie.builder().movieName("Annabelle")
                        .category(Category.HORROR)
                        .description("A couple begins to experience terrifying supernatural occurrences involving " +
                                "a vintage doll shortly after their home is invaded by satanic cultists.")
                        .movieYear(2014)
                        .duration(100)
                        .rating(6.2f)
                        .build(),
                Movie.builder().movieName("Mars Attacks!")
                        .category(Category.SCIFI)
                        .description("Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor.")
                        .movieYear(1950)
                        .duration(70)
                        .rating(5.4f)
                        .build(),
                Movie.builder().movieName("World War 2: The Complete History")
                        .category(Category.DOCUMENTARY)
                        .description("The greatest conflict of the Twentieth Century offers a broad scoped, " +
                                "yet in-depth and neutral perspective of the Second World War.")
                        .movieYear(2000)
                        .duration(80)
                        .rating(8.3f)
                        .build(),
                Movie.builder().movieName("Cassiopeia")
                        .category(Category.COMEDY)
                        .description("Soo-Jin tries to live a perfect life as a lawyer and mother after divorce. Soo-Jin hears the she has Alzheimer's. Her father, " +
                                "In-Woo begins to accompany Soo-Jin and her daughter so that they can live even if she forgets her memories.")
                        .movieYear(2022)
                        .duration(140)
                        .rating(6.3f)
                        .build(),
                Movie.builder().movieName("Babylon")
                        .category(Category.DRAMA)
                        .description("A tale of outsized ambition and outrageous excess, it traces the rise and fall of " +
                                "multiple characters during an era of unbridled decadence and depravity in early Hollywood.")
                        .movieYear(2022)
                        .duration(110)
                        .rating(7.3f)
                        .build(),
                Movie.builder().movieName("Transformers")
                        .category(Category.ACTION)
                        .description("An ancient struggle between two Cybertronian races, the heroic Autobots and the evil " +
                                "Decepticons, comes to Earth, with a clue to the ultimate power held by a teenager.")
                        .movieYear(2007)
                        .duration(140)
                        .rating(7f)
                        .build(),
                Movie.builder().movieName("Menu")
                        .category(Category.HORROR)
                        .description("A young couple travels to a remote island to eat at an exclusive restaurant where the " +
                                "chef has prepared a lavish menu, with some shocking surprises.")
                        .movieYear(2022)
                        .duration(136)
                        .rating(7.2f)
                        .build(),
                Movie.builder().movieName("Knives Out")
                        .category(Category.DRAMA)
                        .description("A detective investigates the death of the patriarch of an eccentric, combative family.")
                        .movieYear(2019)
                        .duration(140)
                        .rating(8.3f)
                        .build(),
                Movie.builder().movieName("Elvis")
                        .category(Category.DRAMA)
                        .description("The life of American music icon Elvis Presley, from his childhood to becoming a rock " +
                                "and movie star in the 1950s while maintaining a complex " +
                                "relationship with his manager, Colonel Tom Parker.")
                        .movieYear(2022)
                        .duration(156)
                        .rating(6f)
                        .build(),
                Movie.builder().movieName(" Once Upon a Time in Hollywood")
                        .category(Category.DRAMA)
                        .description("A faded television actor and his stunt double strive to achieve fame and success" +
                                " in the final years of Hollywood's Golden Age in 1969 Los Angeles.")
                        .movieYear(2019)
                        .duration(156)
                        .rating(7.6f)
                        .build(),
                Movie.builder().movieName("Interstellar")
                        .category(Category.DRAMA)
                        .description("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.")
                        .movieYear(2014)
                        .duration(180)
                        .rating(8.6f)
                        .build(),
                Movie.builder().movieName("La vita è bella")
                        .category(Category.DRAMA)
                        .description("When an open-minded Jewish waiter and his son become victims of the Holocaust, he uses a perfect" +
                                " mixture of will, humor, and imagination to protect his son from the dangers around their camp.")
                        .movieYear(1997)
                        .duration(126)
                        .rating(8.8f)
                        .build(),
                Movie.builder().movieName("Star Wars: Episode VI - Return of the Jedi")
                        .category(Category.ACTION)
                        .description("After a daring mission to rescue Han Solo from Jabba the Hutt, the Rebels dispatch to Endor " +
                                "to destroy the second Death Star. Meanwhile, Luke struggles to help Darth Vader back from the dark " +
                                "side without falling into the Emperor's trap.")
                        .movieYear(1983)
                        .duration(131)
                        .rating(9.8f)
                        .build()
        );



    }
}
