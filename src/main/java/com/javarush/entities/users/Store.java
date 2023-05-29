package com.javarush.entities.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "store")

@Getter
@Setter
@ToString

public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long store_id;


    @Id
    @ManyToMany
    @JoinColumn(name="staff_id")
    @Column(name="manager_staff_id")
    public Staff staff_id;


    @Id
    @OneToOne
    @JoinColumn(name="address_id")
    public Address address_id;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}
