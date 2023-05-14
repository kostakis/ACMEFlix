package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
public class ProfileResourceWithHistory extends ProfileResource {
    List<MovieResourceHistoryResource> movieHistory;
    List<TvShowHistoryResource> tvHistory;
    public ProfileResourceWithHistory(Long profileID, String profileName, Integer viewedMinutes) {
        super(profileID, profileName, viewedMinutes);
    }
}
