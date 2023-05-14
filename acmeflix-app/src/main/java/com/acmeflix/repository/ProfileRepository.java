package com.acmeflix.repository;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.transfer.MovieIdAndWatchedCounter;
import com.acmeflix.transfer.MovieRatedInterface;
import com.acmeflix.transfer.TvShowIdAndWatchedCounter;
import com.acmeflix.transfer.TvShowRatedInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByUser(User user);

    @Query(nativeQuery = true,
            value = " SELECT MOVIEHISTORY as MovieId, COUNT(MOVIEHISTORY) as Counter, MOVIENAME as MovieName, CATEGORY as Category" +
                    " FROM PROFILE_MOVIEHISTORY " +
                    "INNER JOIN MOVIES " +
                    "ON PROFILE_MOVIEHISTORY.MOVIEHISTORY  =  MOVIES.ID " +
                    "GROUP BY MOVIEHISTORY ORDER BY COUNTER DESC " +
                    "FETCH FIRST :max ROWS ONLY"
    )
    List<MovieIdAndWatchedCounter> findTopMovies(@Param("max") int max);


    @Query(nativeQuery = true,
            value = "    SELECT TVSHOWHISTORY as TvShowId, COUNT(TVSHOWHISTORY) as Counter, TVSHOWNAME as TvShowName , CATEGORY as Category" +
                    "    FROM PROFILE_TVSHOWHISTORY " +
                    "    INNER JOIN TVSHOWS" +
                    "    ON PROFILE_TVSHOWHISTORY.TVSHOWHISTORY  =  TVSHOWS.ID" +
                    "    GROUP BY TVSHOWHISTORY ORDER BY COUNTER DESC" +
                    "    FETCH FIRST :max ROWS ONLY"
    )
    List<TvShowIdAndWatchedCounter> findTopSeries(@Param("max") int max);

    @Query(nativeQuery = true,
            value = "SELECT MOVIES.RATING as MovieRating,MOVIES.MOVIENAME as MovieName FROM MOVIES " +
                    "ORDER BY RATING DESC " +
                    "FETCH FIRST :max ROWS ONLY"
    )
    List<MovieRatedInterface> findTopRatedMovies(@Param("max") int max);

    @Query(nativeQuery = true,
            value = "SELECT TVSHOWS.RATING as TvShowRating,TVSHOWS.TVSHOWNAME as TvShowName FROM TVSHOWS " +
                    "ORDER BY RATING DESC " +
                    "FETCH FIRST :max ROWS ONLY "
    )
    List<TvShowRatedInterface> findTopRatedTvShows(@Param("max") int max);
}
