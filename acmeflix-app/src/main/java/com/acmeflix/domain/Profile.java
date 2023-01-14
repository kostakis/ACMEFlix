package com.acmeflix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
//@Builder
@SuperBuilder
@Setter
@Getter
@Entity
@Table(name = "PROFILES", indexes = {@Index(columnList = "user_id")})
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Profile extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY, optional = false) //Many profiles only one user
    private User user; //The user that owns this profile

    @NotNull (message = "Profile name can not be null")
    @Column (nullable = false)
    private String name; //Name of the profile

    @Column
    private Double viewedHours; //How many hours this profile has viewed content movies and series

    @ElementCollection
    @Column
    private List<Long> movieHistory = new ArrayList<>();

    @ElementCollection
    @Column
    private List<Long> tvShowHistory = new ArrayList<>();
}
