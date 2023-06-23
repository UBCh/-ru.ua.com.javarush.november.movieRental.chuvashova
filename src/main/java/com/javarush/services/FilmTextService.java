package com.javarush.services;

import com.javarush.entity.FilmText;
import com.javarush.repository.EntityRepository;

import java.util.HashMap;
import java.util.Map;

public class FilmTextService {

    EntityRepository<FilmText> filmTextRepository;


    public FilmTextService(EntityRepository<FilmText> filmTextRepository) {
	this.filmTextRepository = filmTextRepository;
    }


    public void addFilmText(Integer id, String title, String text) {
	Map<String, Object> map = new HashMap<>();
	map.put("id", id);
	map.put("title", title);
	map.put("description", text);
	filmTextRepository.create(map);
    }

}
