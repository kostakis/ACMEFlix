package com.acmeflix.domain.enumeration;

import javax.persistence.Table;

@Table
//Different movie categories
public enum Category {
    ACTION,
    ANIMATION,
    COMEDY,
    DOCUMENTARY,
    DRAMA,
    HORROR,
    ROMANCE,
    SCIFI
}
