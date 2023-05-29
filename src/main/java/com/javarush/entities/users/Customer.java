package com.javarush.entities.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "customer")

@Getter
@Setter
@ToString

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long customer_id;

    @Id
    @ManyToOne
    @JoinColumn(name="store_id")
    public Store store_id;

    @Column(name = "first_name", length=45)
    String first_name;

    @Column(name = "last_name", length=45)
    String last_name;

    @Column(name = "email", length=50)
    String email;

    @Id
    @OneToOne
    @JoinColumn(name="address_id")
    public Address address_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "active")
    ActiveIndicator active;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


}

