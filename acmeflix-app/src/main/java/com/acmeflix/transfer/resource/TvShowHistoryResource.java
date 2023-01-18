package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class TvShowHistoryResource extends BaseResource {
    Long id;

    String tvShowName;
}
