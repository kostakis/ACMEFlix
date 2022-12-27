package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.MovieCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class Series extends BaseModel {
    private String name;
    private MovieCategory category;
    private Double duration;
    private Float rating;


}
