package com.javarush.repository;

import com.javarush.entity.FilmCategory;
import com.javarush.session_provider.SessionProvider;

import java.util.Map;

public class FilmCategoryRepository implements EntityRepository<FilmCategory> {

    SessionProvider sessionProvider;


    public FilmCategoryRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public void delete(FilmCategory tableEntity) {

    }


    @Override
    public void save(FilmCategory tableEntity) {

    }


    @Override
    public void update(FilmCategory tableEntity) {

    }


    @Override
    public FilmCategory findById(long id) {
	return null;
    }


    @Override
    public FilmCategory findByContent(String content) {
	return null;
    }
}
