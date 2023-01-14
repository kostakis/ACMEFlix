package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.domain.User;
import com.acmeflix.transfer.resource.AccountHistory;
import lombok.NonNull;

import java.util.List;
import java.util.Set;

public interface ProfileService extends BaseService<Profile, Long> {

    Profile createUsingHistory(Profile profile);

    List<Profile> findByUser(User user);

    public List<Profile> findByUserEager(User user);

    List<AccountHistory> mapToAccountHistory(List<Long> allUserIds);

    List<Profile> findAllEager();
}