package com.javarush.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "country_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;

    @Column(name = "country", nullable = false, length = 50)
    private String country;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(mappedBy = "country")
    private Set<City> cities = new LinkedHashSet<>();

}