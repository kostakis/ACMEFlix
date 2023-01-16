package com.acmeflix.transfer.resource;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import lombok.Builder;
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

    private User user;
    private List<ProfileResourceWithHistory> profiles;
}
