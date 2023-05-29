package com.javarush.entities.servises;


import com.javarush.entities.users.Customer;
import com.javarush.entities.users.Staff;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "payment")

@Getter
@Setter
@ToString


public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long payment_id;


    @OneToMany
    @JoinColumn(name="customer_id")
    public Customer customer_id;

    @ManyToMany
    @JoinColumn(name = "staff_id")
    private Staff staff_id;

   @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental_id;


    @Column(name = "amount")
    long amount;

    @Column(name="payment_time")
    private Date payment_time;

    @PrePersist
    protected void onCreate() {
        payment_time = new Date();
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

}
