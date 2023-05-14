package com.acmeflix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name = "PROFILES", indexes = {@Index(columnList = "user_id")})
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Profile extends BaseModel {

    @ManyToOne(optional = false) //Many profiles only one user
    private User user; //The user that owns this profile

    @NotNull(message = "Profile name can not be null")
    @Column(nullable = false)
    private String name; //Name of the profile

    @Column
    private Integer viewedMinutes;

    @ElementCollection
    @Column(name = "MOVIEHISTORY")
    private List<Long> movieHistory = new ArrayList<>();

    @ElementCollection
    @Column(name = "TVSHOWHISTORY")
    private List<Long> tvShowHistory = new ArrayList<>();
}
