package com.acmeflix.transfer.resource;

import com.acmeflix.domain.enumeration.Category;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class MovieResource extends BaseResource {
    String movieName;
    String description;
    Integer movieYear;
    Category category;
    Integer duration;
    Long id;
    Float rating;
}
