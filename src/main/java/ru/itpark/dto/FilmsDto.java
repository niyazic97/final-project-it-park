package ru.itpark.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ru.itpark.entity.FilmsType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmsDto {

    private String name;

    private Integer year;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date worldPremier;
    @Temporal(TemporalType. DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rfPremier;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date premierInGoodQuality;

    @Enumerated(value = EnumType.STRING)
    private FilmsType genre;

    private String plot;

    private String youtubeId;

}
