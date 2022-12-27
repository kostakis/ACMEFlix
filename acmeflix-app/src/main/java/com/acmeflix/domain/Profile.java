package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Profile extends BaseModel {
    private User user; //The user that owns this profile
    private String name; //Name of the profile
    private int viewedHours; //How many hours this profile has viewed content
    private String history;// Viewing history per profile
}
