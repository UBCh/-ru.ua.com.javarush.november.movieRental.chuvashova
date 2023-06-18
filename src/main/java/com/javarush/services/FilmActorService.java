package com.javarush.services;

import com.javarush.entity.FilmActor;
import com.javarush.repository.EntityRepository;

import java.util.HashMap;
import java.util.Map;

public class FilmActorService {
    EntityRepository<FilmActor> filmActorRepository;


    public FilmActorService(EntityRepository<FilmActor> filmActorRepository) {
	this.filmActorRepository = filmActorRepository;
    }


    public void addActorFilm(Integer idFilm, Integer[] idActor) {
	Map<String, Object> map = new HashMap<>();

	for (int i = 0; i < idActor.length; i++) {
	    map.put(String.valueOf(idActor[i]), idFilm);
	}
	filmActorRepository.create(map);
    }

}
