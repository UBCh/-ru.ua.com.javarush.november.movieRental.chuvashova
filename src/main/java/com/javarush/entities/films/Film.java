package com.javarush.entities.films;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;

import java.util.Set;



@Entity
@Table(name = "film")

@Getter
@Setter
@ToString

public class Film {


    public Film() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long film_id;

    @Column(name = "title", length = 128)
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "release_year")
    int release_year;

    @ManyToOne
    @JoinColumn(name = "language_id")
    public Language language_id;

    @ManyToOne
    @JoinColumn(name = "language_id")
    public Language original_language_id;

    @Column(name = "rental_duration")
    int rental_duration;

    @Column(name = "rental_rate")
    long rental_rate;

    @Column(name = "length")
    long length;

    @Column(name = "replacement_cost")
    long replacement_cost;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    Rating rating;

   @ElementCollection
   @Column(name = "special_features")
   Set<String> special_features=Set.of("Trailers", "Commentaries", "Deleted Scenes", "Behind the Scenes");


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


}
