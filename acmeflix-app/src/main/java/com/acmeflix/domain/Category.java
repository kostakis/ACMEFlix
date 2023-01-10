package com.acmeflix.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class Category extends BaseModel {
    @NotNull
    @Column(length = 50, nullable = false)
    private String description;

    public Category(String description) {
        this.description = description;
    }
}
