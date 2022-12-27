package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.MovieCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Movie extends BaseModel {
    String name;
    MovieCategory category;
    Double duration;
    Float rating;
}
