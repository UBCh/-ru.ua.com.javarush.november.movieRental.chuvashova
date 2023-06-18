package com.javarush.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "film_text")
public class FilmText {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "smallint UNSIGNED not null")
    private Integer filmId;


    @Column(name = "title", nullable = false)
    private String title;


    @Lob
    @Column(name = "description")
    private String description;

}