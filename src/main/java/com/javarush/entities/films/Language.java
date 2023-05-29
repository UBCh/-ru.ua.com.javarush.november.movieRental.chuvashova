package com.javarush.entities.films;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "language")

@Getter
@Setter
@ToString

public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long language_id;

    @Column(name = "name", length = 20)
    String name;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;
}