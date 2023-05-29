package com.javarush.entities.films;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "actor")

@Getter
@Setter
@ToString


public class Actor {

    public Actor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long actor_id;


    @Column(name = "first_name", length=45)
    String first_name;

    @Column(name = "last_name", length=45)
    String last_name;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}
