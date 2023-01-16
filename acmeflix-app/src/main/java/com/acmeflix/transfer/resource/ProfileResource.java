package com.acmeflix.transfer.resource;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
public class ProfileResource extends BaseResource {
    private Long profileID;
    private String profileName;
    private Integer viewedMinutes;
}
