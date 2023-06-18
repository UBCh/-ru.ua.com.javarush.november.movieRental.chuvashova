package com.javarush.repository;

import com.javarush.entity.FilmText;
import com.javarush.session_provider.SessionProvider;

import java.util.Map;

public class FilmTextRepository implements EntityRepository<FilmText> {

    SessionProvider sessionProvider;


    public FilmTextRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map map) {

    }


    @Override
    public void delete(FilmText tableEntity) {

    }


    @Override
    public void save(FilmText tableEntity) {

    }


    @Override
    public void update(FilmText tableEntity) {

    }


    @Override
    public FilmText findById(long id) {
	return null;
    }


    @Override
    public FilmText findByContent(String content) {
	return null;
    }
}
