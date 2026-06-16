package com.acmeflix.transfer.resource;

import java.util.List;

public class AccountHistory extends BaseResource {
    private UserResource user;
    private List<ProfileResourceWithHistory> profiles;

    public AccountHistory() {
    }

    public AccountHistory(UserResource user, List<ProfileResourceWithHistory> profiles) {
        this.user = user;
        this.profiles = profiles;
    }

    public UserResource getUser() {
        return user;
    }

    public void setUser(UserResource user) {
        this.user = user;
    }

    public List<ProfileResourceWithHistory> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileResourceWithHistory> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        return "AccountHistory{" +
                "user=" + user +
                ", profiles=" + profiles +
                '}';
    }
}
