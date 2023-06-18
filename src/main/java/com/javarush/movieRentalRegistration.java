package com.javarush;

import com.javarush.entity.*;
import com.javarush.repository.*;
import com.javarush.services.*;
import com.javarush.session_provider.PropertiesSessionProvider;

import java.math.BigDecimal;

public class movieRentalRegistration {

    Integer[] idActor = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10};


    EntityRepository<Film> filmRepository = new FilmRepository(new PropertiesSessionProvider());


    EntityRepository<FilmText> filmTextRepository = new FilmTextRepository(new PropertiesSessionProvider());


    EntityRepository<FilmActor> filmActorRepository = new FilmActorRepository(new PropertiesSessionProvider());


    EntityRepository<FilmCategory> filmCategoryRepository = new FilmCategoryRepository(new PropertiesSessionProvider());


    EntityRepository<Language> languageRepository = new LanguageRepository(new PropertiesSessionProvider());


    FilmService filmService = new FilmService(filmRepository);


    FilmTextService filmTextService = new FilmTextService(filmTextRepository);


    FilmCategoryService filmCategoryService = new FilmCategoryService(filmCategoryRepository);


    FilmActorService filmActorService = new FilmActorService(filmActorRepository);


    LanguageService languageService = new LanguageService(languageRepository);
    //    method of receiving data from film


    public void registerMovie() {

	Language language = languageService.getLanguage("English");
	BigDecimal i = BigDecimal.valueOf(0);

	Language Language_original = new Language();
	Film film = filmService.addMovie("EVOLUTION", 2006, language, language, (short) 0, BigDecimal.valueOf(0), 120, BigDecimal.valueOf(0), Rating.R, "Trailers,Commentaries", Long.valueOf(language.getId()));
	addTextMovie(film);
	addFilmActor(film);
	addCategoryMovie(film);
    }


    public void addTextMovie(Film film) {

	filmTextService.addFilmText(film.getId(), film.getTitle(), film.getDescription());
    }


    public void addFilmActor(Film film) {

	filmActorService.addActorFilm(film.getId(), idActor);
    }


    public void addCategoryMovie(Film film) {
	filmCategoryService.addFilmCategory(film.getId(), 0);
    }
}
