package com.javarush.DTO;

import com.javarush.entity.Language;
import com.javarush.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class FilmDTO {


    private String title;


    private Integer releaseYear;


    private Language language;


    private Language original_language;


    private Short rentalDuration;


    private BigDecimal rentalRate;


    private Integer length;


    private BigDecimal replacementCost;


    private Rating rating;


    private String specialFeatures;


    private Long original_language1;


    private String description;


    private Integer[] idActor;


    private String category;

}
