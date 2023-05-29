package com.javarush.entities.servises;

import com.javarush.entities.films.Film;
import com.javarush.entities.users.Customer;
import com.javarush.entities.users.Staff;
import com.javarush.entities.users.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "rental")

@Getter
@Setter
@ToString

public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long rental_id;

    @Column(name="rental_date")
    private Date rental_date;

    @OneToOne
    @JoinColumn(name="inventory_id")
    public Inventory inventory_id;


    @OneToMany
    @JoinColumn(name="customer_id")
    public Customer customer_id;

    @Column(name="return_date")
    private Date return_date;


    @ManyToMany
    @JoinColumn(name = "staff_id")
    private Staff staff_id;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


}