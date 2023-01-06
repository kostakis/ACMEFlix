package com.acmeflix.domain;

import java.util.ArrayList;

public class Description {
    private ArrayList<String> directors;
    private ArrayList<String> castMembers;
    private String description;

    public Description() {
        directors = new ArrayList<>();
        castMembers = new ArrayList<>();
    }

    public void addDirectors(String director) {
        directors.add(director);

    }

    public void addCastMembers(String castMember) {
        castMembers.add(castMember);
    }

    public void setDescription(String description){
        this.description = description;
    }
}