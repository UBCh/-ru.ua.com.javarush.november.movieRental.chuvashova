package com.javarush;

import com.javarush.DTO.FilmDTO;
import com.javarush.entity.*;
import com.javarush.repository.*;
import com.javarush.services.*;
import com.javarush.session_provider.PropertiesSessionProvider;

import java.util.List;

public class MovieRentalRegistration {

    private final Integer[] idActor = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 10};


    private final EntityRepository<Film> filmRepository = new FilmRepository(new PropertiesSessionProvider());


    private final EntityRepository<FilmText> filmTextRepository = new FilmTextRepository(new PropertiesSessionProvider());


    private final EntityRepository<FilmActor> filmActorRepository = new FilmActorRepository(new PropertiesSessionProvider());


    private final EntityRepository<FilmCategory> filmCategoryRepository = new FilmCategoryRepository(new PropertiesSessionProvider());


    private final EntityRepository<Language> languageRepository = new LanguageRepository(new PropertiesSessionProvider());


    private final EntityRepository<Actor> actorRepository = new ActorRepository(new PropertiesSessionProvider());


    private final EntityRepository<Category> categoryRepository = new CategoryRepository(new PropertiesSessionProvider());


    private final FilmService filmService = new FilmService(filmRepository);


    private final FilmTextService filmTextService = new FilmTextService(filmTextRepository);


    private final FilmCategoryService filmCategoryService = new FilmCategoryService(filmCategoryRepository, categoryRepository);


    LanguageService languageService = new LanguageService(languageRepository);


    FilmActorService filmActorService = new FilmActorService(filmActorRepository, filmRepository, actorRepository);


    //    method of receiving data from film
    FilmDTO filmDTO;


    public MovieRentalRegistration(FilmDTO filmDTO) {
	this.filmDTO = filmDTO;
    }


    public void registerMovie() {

	Film film = filmService.addMovie(filmDTO);
	addTextMovie(film);
	addFilmActor(film);
	addCategoryMovie(film, "Comedy");
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
	System.out.println("actor");
	List<Actor> list = filmActorService.getActors(film.getId());
	list.forEach(System.out::println);

    }
}
