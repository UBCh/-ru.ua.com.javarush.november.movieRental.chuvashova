package com.javarush.entities.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "address")

@Getter
@Setter
@ToString

public class Address {

    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long address_id;

    @Column(name = "address", length=50)
    String address;

    @Column(name = "address2", length=50)
    String address2;

    @Column(name = "district", length=50)
    String district;


    @OneToMany
    @JoinColumn(name="city_id")
    public City city_id;

    @Column(name = "postal_code", length=10)
    String postal_code ;

    @Column(name = "phone", length=10)
    String phone ;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;
}
