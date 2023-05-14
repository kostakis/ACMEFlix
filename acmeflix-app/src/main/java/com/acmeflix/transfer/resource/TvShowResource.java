package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class TvShowResource extends BaseResource {
    Long id;
    String tvShowName;
    Float rating;
}
