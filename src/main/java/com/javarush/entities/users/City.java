package com.javarush.entities.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "city")

@Getter
@Setter
@ToString

public class City {

    public City() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long city_id;

    @Column(name = "city", length=50)
    String city;



    @OneToMany
    @JoinColumn(name="country_id")
    public Country country_id;



    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}
