package com.javarush.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", columnDefinition = "tinyint UNSIGNED not null")
    private Integer id;


    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;


    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;


    @Column(name = "picture")
    private String picture;


    @Column(name = "email", length = 50)
    private String email;


    @Column(name = "active", nullable = false)
    private Boolean active = false;


    @Column(name = "username", nullable = false, length = 16)
    private String username;


    @Column(name = "password", length = 40)
    private String password;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}