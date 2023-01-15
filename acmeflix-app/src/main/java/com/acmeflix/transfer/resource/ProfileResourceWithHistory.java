package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProfileResourceWithHistory extends ProfileResource {
    public ProfileResourceWithHistory(Long profileID, String profileName, Integer viewedMinutes) {
        super(profileID, profileName, viewedMinutes);
    }

    List<MovieResource> movieHistory;
    //TODO SHOWS
}
