package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.Movie;
import com.acmeflix.domain.enumeration.Category;
import com.acmeflix.service.MovieService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("my-dev")

@Order(3)
public class GenerateMovies extends AbstractLogComponent implements CommandLineRunner {

    private final MovieService movieService;

    public GenerateMovies(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateMovies");

        var movies = movieService.createAll(
                new Movie("Titanic", Category.ROMANCE, "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", 1997, 120, 7.9f),
                new Movie("Top Gun", Category.ACTION, "As students at the United States Navy's elite fighter weapons school compete to be best in the class, one daring young pilot learns a few things from a civilian instructor that are not taught in the classroom.", 1986, 125, 6.9f),
                new Movie("How to train your dragon", Category.ANIMATION, "A hapless young Viking who aspires to hunt dragons becomes the unlikely friend of a young dragon himself, and learns there may be more to the creatures than he assumed.", 2010, 100, 8.1f),
                new Movie("Toy Story ", Category.ANIMATION, "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", 1995, 88, 9.3f),
                new Movie("Toy Story 2", Category.ANIMATION, "When Woody is stolen by a toy collector, Buzz and his friends set out on a rescue mission to save Woody before he becomes a museum toy property with his roundup gang Jessie, Prospector, and Bullseye.", 1999, 105, 8.5f),
                new Movie("Toy Story 3", Category.ANIMATION, "The toys are mistakenly delivered to a day-care center instead of the attic right before Andy leaves for college, and it's up to Woody to convince the other toys that they weren't abandoned and to return home.", 2010, 110, 9f),
                new Movie("Me before you", Category.DRAMA, "A girl in a small town forms an unlikely bond with a recently-paralyzed man she's taking care of.", 2016, 95, 7.4f),
                new Movie(" The Conjuring", Category.HORROR, "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.", 2013, 85, 6.3f),
                new Movie("Conjuring 2", Category.HORROR, "Ed and Lorraine Warren travel to North London to help a single mother raising four children alone in a house plagued by a supernatural spirit.", 2018, 80, 6.5f),
                new Movie("The Conjuring: The Devil Made Me Do It", Category.HORROR, "The Warrens investigate a murder that may be linked to a demonic possession.", 2021, 90, 7.4f),
                new Movie("Annabelle", Category.HORROR, "A couple begins to experience terrifying supernatural occurrences involving a vintage doll shortly after their home is invaded by satanic cultists.", 2014, 100, 6.2f),
                new Movie("Mars Attacks!", Category.SCIFI, "Earth is invaded by Martians with unbeatable weapons and a cruel sense of humor.", 1950, 70, 5.4f),
                new Movie("World War 2: The Complete History", Category.DOCUMENTARY, "The greatest conflict of the Twentieth Century offers a broad scoped, yet in-depth and neutral perspective of the Second World War.", 2000, 80, 8.3f),
                new Movie("Cassiopeia", Category.COMEDY, "Soo-Jin tries to live a perfect life as a lawyer and mother after divorce. Soo-Jin hears the she has Alzheimer's. Her father, In-Woo begins to accompany Soo-Jin and her daughter so that they can live even if she forgets her memories.", 2022, 140, 6.3f),
                new Movie("Babylon", Category.DRAMA, "A tale of outsized ambition and outrageous excess, it traces the rise and fall of multiple characters during an era of unbridled decadence and depravity in early Hollywood.", 2022, 110, 7.3f),
                new Movie("Transformers", Category.ACTION, "An ancient struggle between two Cybertronian races, the heroic Autobots and the evil Decepticons, comes to Earth, with a clue to the ultimate power held by a teenager.", 2007, 140, 7f),
                new Movie("Menu", Category.HORROR, "A young couple travels to a remote island to eat at an exclusive restaurant where the chef has prepared a lavish menu, with some shocking surprises.", 2022, 136, 7.2f),
                new Movie("Knives Out", Category.DRAMA, "A detective investigates the death of the patriarch of an eccentric, combative family.", 2019, 140, 8.3f),
                new Movie("Elvis", Category.DRAMA, "The life of American music icon Elvis Presley, from his childhood to becoming a rock and movie star in the 1950s while maintaining a complex relationship with his manager, Colonel Tom Parker.", 2022, 156, 6f),
                new Movie(" Once Upon a Time in Hollywood", Category.DRAMA, "A faded television actor and his stunt double strive to achieve fame and success in the final years of Hollywood's Golden Age in 1969 Los Angeles.", 2019, 156, 7.6f),
                new Movie("Interstellar", Category.DRAMA, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", 2014, 180, 8.6f),
                new Movie("La vita è bella", Category.DRAMA, "When an open-minded Jewish waiter and his son become victims of the Holocaust, he uses a perfect mixture of will, humor, and imagination to protect his son from the dangers around their camp.", 1997, 126, 8.8f),
                new Movie("Star Wars: Episode VI - Return of the Jedi", Category.ACTION, "After a daring mission to rescue Han Solo from Jabba the Hutt, the Rebels dispatch to Endor to destroy the second Death Star. Meanwhile, Luke struggles to help Darth Vader back from the dark side without falling into the Emperor's trap.", 1983, 131, 9.8f)
        );
    }
}
