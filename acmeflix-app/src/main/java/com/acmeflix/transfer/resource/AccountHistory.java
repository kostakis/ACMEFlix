package com.acmeflix.transfer.resource;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class AccountHistory extends BaseResource {

    private UserResource user;
    private List<ProfileResourceWithHistory> profiles;
}
