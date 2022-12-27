package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Profile extends BaseModel {
    User user; //The user that owns this profile

    String name; //Name of the profile

    int viewedHours; //How many hours this profile has viewed content
}
