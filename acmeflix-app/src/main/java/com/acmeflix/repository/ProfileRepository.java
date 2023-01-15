package com.acmeflix.repository;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.transfer.KeyValue;
import com.acmeflix.transfer.MovieIdAndWatchedCounter;
import com.acmeflix.transfer.TvShowIdAndWatchedCounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByUser(User user);

    @Query(nativeQuery = true,
            value = " SELECT MOVIEHISTORY as MovieId, COUNT(MOVIEHISTORY) as Counter, MOVIENAME as MovieName FROM PROFILE_MOVIEHISTORY " +
                    "INNER JOIN MOVIES " +
                    "ON PROFILE_MOVIEHISTORY.MOVIEHISTORY  =  MOVIES.ID " +
                    "GROUP BY MOVIEHISTORY ORDER BY COUNTER DESC " +
                    "FETCH FIRST 10 ROWS ONLY"
    )
    List<MovieIdAndWatchedCounter> findTopTenMovies();


    @Query(nativeQuery = true,
            value = "    SELECT TVSHOWHISTORY as TvShowId, COUNT(TVSHOWHISTORY) as Counter, TVSHOWNAME as TvShowName FROM PROFILE_TVSHOWHISTORY " +
                    "    INNER JOIN TVSHOWS" +
                    "    ON PROFILE_TVSHOWHISTORY.TVSHOWHISTORY  =  TVSHOWS.ID" +
                    "    GROUP BY TVSHOWHISTORY ORDER BY COUNTER DESC" +
                    "    FETCH FIRST 10 ROWS ONLY"
    )
    List<TvShowIdAndWatchedCounter> findTopTenSeries();


}
