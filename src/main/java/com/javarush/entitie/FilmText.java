package com.javarush.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "film_text")
public class FilmText {

    @OneToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film filmId;

    @Id
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;



}