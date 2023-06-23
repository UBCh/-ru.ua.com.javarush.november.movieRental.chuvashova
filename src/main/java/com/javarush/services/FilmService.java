package com.javarush.services;

import com.javarush.DTO.FilmDTO;
import com.javarush.entity.Film;
import com.javarush.repository.EntityRepository;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class FilmService {


    EntityRepository<Film> filmRepository;


    public FilmService(EntityRepository<Film> filmRepository) {
	this.filmRepository = filmRepository;
    }


    @SneakyThrows
    public Film addMovie(FilmDTO filmDTO
    ) {

	Map<String, Object> map = new HashMap<>();
	map.put("title", filmDTO.getTitle());
	map.put("releaseYear", filmDTO.getReleaseYear());
	map.put("language", filmDTO.getLanguage());
	map.put("original_language", filmDTO.getOriginal_language());
	map.put("rentalDuration", filmDTO.getRentalDuration());
	map.put("rentalRate", filmDTO.getRentalRate());
	map.put("length", filmDTO.getLength());
	map.put("replacementCost", filmDTO.getReplacementCost());
	map.put("rating", filmDTO.getRating());
	map.put("specialFeatures", filmDTO.getSpecialFeatures());
	map.put("original_language1", filmDTO.getOriginal_language1());
	map.put("description", filmDTO.getDescription());
	filmRepository.create(map);

	return filmRepository.findByContent(filmDTO.getTitle());
    }


    @SneakyThrows
    public Film getFilmByTitle(String title) {
	return filmRepository.findByContent(title);

    }
}
