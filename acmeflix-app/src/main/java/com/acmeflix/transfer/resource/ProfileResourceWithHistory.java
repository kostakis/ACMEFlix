package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
public class ProfileResourceWithHistory extends ProfileResource {
    public ProfileResourceWithHistory(Long profileID, String profileName, Integer viewedMinutes) {
        super(profileID, profileName, viewedMinutes);
    }

    List<MovieResourceHistoryResource> movieHistory;
    List<TvShowHistoryResource> tvHistory;
}
