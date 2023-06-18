package com.javarush.services;

import com.javarush.entity.Film;
import com.javarush.entity.Language;
import com.javarush.entity.Rating;
import com.javarush.repository.EntityRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FilmService {


    EntityRepository<Film> filmRepository;


    public FilmService(EntityRepository<Film> filmRepository) {
	this.filmRepository = filmRepository;
    }


    public Film addMovie(String title, Integer releaseYear,
			 Language language, Language original_language,
			 Short rentalDuration, BigDecimal rentalRate,
			 Integer length, BigDecimal replacementCost,
			 Rating rating, String specialFeatures,
			 Long original_language1
    ) {

	Map<String, Object> map = new HashMap<>();
	map.put("title", title);
	map.put("releaseYear", releaseYear);
	map.put("language", language);
	map.put("original_language", original_language);
	map.put("rentalDuration", rentalDuration);
	map.put("rentalRate", rentalRate);
	map.put("length", length);
	map.put("replacementCost", replacementCost);
	map.put("rating", rating);
	map.put("specialFeatures", specialFeatures);
	map.put("original_language1", original_language1);
	filmRepository.create(map);

	return filmRepository.findByContent(title);
    }

}
