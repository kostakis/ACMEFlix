package com.acmeflix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "TVSHOWEPISODES")
public class TvShowEpisodes extends BaseModel {

    @NotNull
    @Column(nullable = false)
    private Integer season;

    @Column(nullable = false)
    private Integer episode;

    @NotNull
    @Column(nullable = false)
    private Integer duration; //Minutes
}
