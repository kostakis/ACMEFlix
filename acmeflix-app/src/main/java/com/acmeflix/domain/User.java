package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User extends BaseModel{
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    static int maxProfiles = 4; //Each user may have up to 4 profiles
}
