package com.javarush.DTO;

import com.javarush.entity.Language;
import com.javarush.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FilmDTO {


    String title;


    Integer releaseYear;


    Language language;


    Language original_language;


    Short rentalDuration;


    BigDecimal rentalRate;


    Integer length;


    BigDecimal replacementCost;


    Rating rating;


    String specialFeatures;


    Long original_language1;


    String description;
}
