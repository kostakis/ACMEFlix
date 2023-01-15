package com.acmeflix.transfer.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TvShowResource extends BaseResource {
    Long id;

    String tvShowName;
}
