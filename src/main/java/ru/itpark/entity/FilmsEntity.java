package ru.itpark.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "films")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

    @Column(name = "world_premier")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date worldPremier;

    @Column(name = "rf_premier")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rfPremier;

    @Column(name = "premier_in_good_quality")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premiereInGoodQuality;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private FilmsType genre;

    @Column(name = "plot", length = 1000)
    private String plot;

    @Column(name = "youtube_id")
    private String youtubeId;

    @Column(name = "path")
    private String path;
}
