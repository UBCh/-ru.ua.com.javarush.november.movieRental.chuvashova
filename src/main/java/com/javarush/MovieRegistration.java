package com.javarush;

import com.javarush.DTO.FilmDTO;
import com.javarush.entity.*;
import com.javarush.repository.*;
import com.javarush.services.FilmActorService;
import com.javarush.services.FilmCategoryService;
import com.javarush.services.FilmService;
import com.javarush.services.FilmTextService;
import com.javarush.session_provider.PropertiesSessionProvider;

public class MovieRegistration {


    private final Integer[] idActor;


    private final EntityRepository<Film> filmRepository = new FilmRepository(new PropertiesSessionProvider());


    private final EntityRepository<FilmText> filmTextRepository = new FilmTextRepository(new PropertiesSessionProvider());


    private final EntityRepository<FilmActor> filmActorRepository = new FilmActorRepository(new PropertiesSessionProvider());


    private final EntityRepository<FilmCategory> filmCategoryRepository = new FilmCategoryRepository(new PropertiesSessionProvider());


    private final EntityRepository<Actor> actorRepository = new ActorRepository(new PropertiesSessionProvider());


    private final EntityRepository<Category> categoryRepository = new CategoryRepository(new PropertiesSessionProvider());


    private final FilmService filmService = new FilmService(filmRepository);


    private final FilmTextService filmTextService = new FilmTextService(filmTextRepository);


    private final FilmCategoryService filmCategoryService = new FilmCategoryService(filmCategoryRepository, categoryRepository);


    FilmActorService filmActorService = new FilmActorService(filmActorRepository, filmRepository, actorRepository);


    FilmDTO filmDTO;


    public MovieRegistration(FilmDTO filmDTO) {
	this.filmDTO = filmDTO;
	this.idActor = filmDTO.getIdActor();
    }


    public void registerMovie() {

	Film film = filmService.addMovie(filmDTO);
	addTextMovie(film);
	addFilmActor(film);
	addCategoryMovie(film, filmDTO.getCategory());
	printFilm(film);
    }


    public void addTextMovie(Film film) {

	filmTextService.addFilmText(film.getId(), film.getTitle(), film.getDescription());
    }


    public void addFilmActor(Film film) {

	filmActorService.addActorFilm(film.getId(), idActor);
    }


    public void addCategoryMovie(Film film, String category) {
	filmCategoryService.addFilmCategory(film, category);
    }


    public void printFilm(Film film) {
	System.out.println(film.getId() + "=id");
	System.out.println(film.getTitle() + "=title");
	System.out.println(filmTextRepository.findById(film.getId()).getDescription() + "=description");

    }
}
