package com.javarush.entities.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "country")

@Getter
@Setter
@ToString



public class Country {

    public Country() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long country_id;


    @Column(name = "country", length=50)
    String country;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}
