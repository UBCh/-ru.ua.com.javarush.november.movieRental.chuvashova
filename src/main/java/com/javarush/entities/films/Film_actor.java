package com.javarush.entities.films;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "film_actor")

@Getter
@Setter
@ToString


public class Film_actor {

    @Id
    @ManyToOne
    @JoinColumn(name="actor_id")
    public Actor actor_id;

    @Id
    @ManyToOne
    @JoinColumn(name="film_id")
    public Film film_id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


}
