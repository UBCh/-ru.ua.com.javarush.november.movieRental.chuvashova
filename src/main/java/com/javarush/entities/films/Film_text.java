package com.javarush.entities.films;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "film_text")

@Getter
@Setter
@ToString

public class Film_text {

    @Id
    @OneToOne
    @JoinColumn(name="film_id")
    public Film film_id;

    @Column(name = "title", length=254)
    String title;

    @Column(name = "description")
    String description;

}
