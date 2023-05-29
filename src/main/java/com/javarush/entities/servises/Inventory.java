package com.javarush.entities.servises;

import com.javarush.entities.films.Film;
import com.javarush.entities.users.ActiveIndicator;
import com.javarush.entities.users.Address;
import com.javarush.entities.users.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "inventory")

@Getter
@Setter
@ToString

public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long inventory_id;


    @ManyToMany
    @JoinColumn(name="film_id")
    public Film film_id;

    @OneToOne
    @JoinColumn(name="store_id")
    public Store store_id;


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;


}