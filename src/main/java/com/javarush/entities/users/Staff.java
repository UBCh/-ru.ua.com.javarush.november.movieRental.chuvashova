package com.javarush.entities.users;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "staff")

@Getter
@Setter
@ToString

public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long staff_id;


    @Column(name = "first_name", length=45)
    String first_name;

    @Column(name = "last_name", length=45)
    String last_name;

    @Id
    @OneToOne
    @JoinColumn(name="address_id")
    public Address address_id;


    @Lob
    @Column(name = "picture", columnDefinition="BLOB")
    private byte[] photo;

    @Column(name = "email", length=50)
    String email;

    @Id
    @ManyToOne
    @JoinColumn(name="store_id")
    public Store store_id;


    @Enumerated(EnumType.STRING)
    @Column(name = "active")
    ActiveIndicator active;


    @Column(name = "username", length=16)
    String username;

    @Column(name = "password", length=40)
    String password;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;
}
