package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class MovieResource extends BaseResource {
    String movieName;
    Long id;
    Float rating;
}
