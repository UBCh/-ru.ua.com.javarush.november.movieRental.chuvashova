package com.javarush.services;

import com.javarush.entity.Actor;
import com.javarush.entity.Film;
import com.javarush.entity.FilmActor;
import com.javarush.repository.EntityRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilmActorService {
    EntityRepository<FilmActor> filmActorRepository;


    EntityRepository<Film> filmRepository;


    EntityRepository<Actor> actorRepository;


    public FilmActorService(EntityRepository<FilmActor> filmActorRepository,
			    EntityRepository<Film> filmRepository,
			    EntityRepository<Actor> actorRepository) {
	this.filmActorRepository = filmActorRepository;
	this.filmRepository = filmRepository;
	this.actorRepository = actorRepository;
    }


    public void addActorFilm(Integer idFilm, Integer[] idActor) {
	for (int i = 0; i < idActor.length; i++) {
	    FilmActor filmActor = new FilmActor();
	    filmActor.setActor(actorRepository.findById(idActor[i]));
	    filmActor.setFilm(filmRepository.findById(idFilm));
	    filmActor.setLast_update(new Date());
	    filmActorRepository.save(filmActor);
	}

    }


    public List<Actor> getActors(Integer idFilm) {
	List<Actor> actorList = new ArrayList<>();
	Integer id = 0;
	for (FilmActor f : filmActorRepository.findList(String.valueOf(idFilm))) {
	    id = f.getFilm().getId();
	    if (id.equals(idFilm)) {
		actorList.add(f.getActor());
	    }
	}
	return actorList;
    }

}
