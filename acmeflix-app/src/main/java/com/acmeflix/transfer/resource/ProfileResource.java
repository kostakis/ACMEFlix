package com.acmeflix.transfer.resource;

public class ProfileResource extends BaseResource {
    private Long profileID;
    private String profileName;
    private Integer viewedMinutes;

    public ProfileResource() {
    }

    public ProfileResource(Long profileID, String profileName, Integer viewedMinutes) {
        this.profileID = profileID;
        this.profileName = profileName;
        this.viewedMinutes = viewedMinutes;
    }

    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Integer getViewedMinutes() {
        return viewedMinutes;
    }

    public void setViewedMinutes(Integer viewedMinutes) {
        this.viewedMinutes = viewedMinutes;
    }

    @Override
    public String toString() {
        return "ProfileResource{" +
                "profileID=" + profileID +
                ", profileName='" + profileName + '\'' +
                ", viewedMinutes=" + viewedMinutes +
                '}';
    }
}
