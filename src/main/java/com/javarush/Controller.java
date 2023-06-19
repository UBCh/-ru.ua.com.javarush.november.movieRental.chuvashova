package com.javarush;

import com.javarush.DTO.FilmDTO;
import com.javarush.entity.Language;
import com.javarush.entity.Rating;
import com.javarush.repository.LanguageRepository;
import com.javarush.services.LanguageService;
import com.javarush.session_provider.PropertiesSessionProvider;

import java.math.BigDecimal;

public class Controller {

    public static void main(String[] args) {
	LanguageService languageService = new LanguageService(new LanguageRepository(new PropertiesSessionProvider()));
	Language language = languageService.getLanguage("English");
	BigDecimal i = BigDecimal.valueOf(0);
	FilmDTO filmDTO = new FilmDTO("bwа аывмa", 2006, language, language, (short) 0, BigDecimal.valueOf(0), 120, BigDecimal.valueOf(0), Rating.R, "Trailers,Commentaries", Long.valueOf(language.getId()), "A Touching Epistle of a Madman And a Mad Cow who must Defeat a Student in Nigeria");
	MovieRentalRegistration movieRentalRegistration = new MovieRentalRegistration(filmDTO);
	movieRentalRegistration.registerMovie();
    }
}


