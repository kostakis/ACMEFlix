package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class UserResource extends BaseResource{
    private Long id;

    private String email;

    private String firstName;

    private String lastName;
}
