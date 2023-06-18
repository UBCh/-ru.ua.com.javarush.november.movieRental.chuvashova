package com.javarush.services;

import com.javarush.entity.FilmCategory;
import com.javarush.repository.EntityRepository;

import java.util.HashMap;
import java.util.Map;

public class FilmCategoryService {

    EntityRepository<FilmCategory> filmCategoryRepository;


    public FilmCategoryService(EntityRepository<FilmCategory> filmCategoryRepository) {
	this.filmCategoryRepository = filmCategoryRepository;
    }


    public void addFilmCategory(Integer id, Integer categoryId) {
	Map<String, Object> map = new HashMap<>();
	map.put("id", id);
	map.put("category_id", categoryId);
	filmCategoryRepository.create(map);

    }

}
