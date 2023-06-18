package com.javarush.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;


    @Column(name = "address", nullable = false, length = 50)
    private String address;


    @Column(name = "address2", length = 50)
    private String address2;


    @Column(name = "district", nullable = false, length = 20)
    private String district;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;


    @Column(name = "postal_code", length = 10)
    private String postalCode;


    @Column(name = "phone", nullable = false, length = 20)
    private String phone;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


    @OneToMany(mappedBy = "address")
    private Set<Customer> customers = new LinkedHashSet<>();


    @OneToMany(mappedBy = "address")
    private Set<Staff> staff = new LinkedHashSet<>();


    @OneToMany(mappedBy = "address")
    private Set<Store> stores = new LinkedHashSet<>();

}