package com.javarush.repository;

import com.javarush.entity.FilmActor;
import com.javarush.session_provider.SessionProvider;

import java.util.Map;

public class FilmActorRepository implements EntityRepository<FilmActor> {

    SessionProvider sessionProvider;


    public FilmActorRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map map) {

    }


    @Override
    public void delete(FilmActor tableEntity) {

    }


    @Override
    public void save(FilmActor tableEntity) {

    }


    @Override
    public void update(FilmActor tableEntity) {

    }


    @Override
    public FilmActor findById(long id) {
	return null;
    }


    @Override
    public FilmActor findByContent(String content) {
	return null;
    }
}
