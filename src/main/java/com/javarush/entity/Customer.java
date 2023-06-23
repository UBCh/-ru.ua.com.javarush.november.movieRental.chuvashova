package com.javarush.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class Customer {


    @ManyToOne
    @JoinColumn(name = "store_id")
    public Store store_id;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "active")
    ActiveIndicator active;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer id;


    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;


    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;


    @Column(name = "email", length = 50)
    private String email;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;


    @Column(name = "create_date")
    private Date create_date;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}