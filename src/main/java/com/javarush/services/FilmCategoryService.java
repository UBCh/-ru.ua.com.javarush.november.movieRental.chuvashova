package com.javarush.services;

import com.javarush.entity.Category;
import com.javarush.entity.Film;
import com.javarush.entity.FilmCategory;
import com.javarush.repository.EntityRepository;

import java.util.Date;

public class FilmCategoryService {

    EntityRepository<FilmCategory> filmCategoryRepository;


    EntityRepository<Category> categoryRepository;


    public FilmCategoryService(EntityRepository<FilmCategory> filmCategoryRepository, EntityRepository<Category> categoryRepository) {
	this.filmCategoryRepository = filmCategoryRepository;
	this.categoryRepository = categoryRepository;
    }


    public void addFilmCategory(Film film, String category) {
	Category cat = categoryRepository.findByContent(category);
	FilmCategory filmCategory = new FilmCategory();
	filmCategory.setCategory(cat);
	filmCategory.setFilm(film);
	filmCategory.setLast_update(new Date());
	filmCategoryRepository.save(filmCategory);

    }

}
