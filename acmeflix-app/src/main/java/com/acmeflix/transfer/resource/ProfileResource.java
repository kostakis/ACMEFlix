package com.acmeflix.transfer.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ProfileResource extends BaseResource {
    private Long profileID;
    private String profileName;
    private Double viewedMinutes;
}
