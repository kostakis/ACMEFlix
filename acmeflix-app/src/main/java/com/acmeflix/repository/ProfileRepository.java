package com.acmeflix.repository;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.transfer.KeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    List<Profile> findByUser(User user);

    @Query(value  = "SELECT new com.acmeflix.transfer.KeyValue(MOVIE_ID, COUNTER) MOVIEHISTORY as MOVIE_ID, COUNT(MOVIEHISTORY) as COUNTER FROM PROFILE_MOVIEHISTORY GROUP BY MOVIEHISTORY", nativeQuery = true)
    List<KeyValue<Long, Integer>> findMostWatchedContent();
}
