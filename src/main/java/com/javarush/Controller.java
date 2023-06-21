package com.javarush;

import com.javarush.DTO.AdressDTO;
import com.javarush.DTO.CustomerDTO;
import com.javarush.DTO.FilmDTO;
import com.javarush.entity.Language;
import com.javarush.entity.Rating;
import com.javarush.repository.LanguageRepository;
import com.javarush.services.LanguageService;
import com.javarush.session_provider.PropertiesSessionProvider;

import java.math.BigDecimal;

public class Controller {

    public static void main(String[] args) {
//	addMovie();
//	addCustomer();
	customerReturnMovie();
    }


    private static void addMovie() {
	LanguageService languageService = new LanguageService(new LanguageRepository(new PropertiesSessionProvider()));
	Language language = languageService.getLanguage("English");
	Integer[] idActor = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 10};
	BigDecimal i = BigDecimal.valueOf(0);
	FilmDTO filmDTO = new FilmDTO("bwcsacascвмa",
		2006, language, language, (short) 0,
		BigDecimal.valueOf(0), 120, BigDecimal.valueOf(0),
		Rating.R, "Trailers,Commentaries",
		Long.valueOf(language.getId()),
		"A Touching Epistle of a Madman And a Mad Cow who must Defeat a Student in Nigeria",
		idActor, "Comedy");
	MovieRegistration movieRentalRegistration = new MovieRegistration(filmDTO);
	movieRentalRegistration.registerMovie();

    }


    private static void addCustomer() {

	CustomerDTO customerDTO = new CustomerDTO(
		"Mucya", "Popova",
		"jfd@kbmail.ru", "Arecibo", 1);

	AdressDTO adressDTO = new AdressDTO(
		"MySakila Drive", "",
		"Alberta", "156675",
		"97655434321");
	BuyerRegistration buyerRegistration = new BuyerRegistration();
	buyerRegistration.registerCustomer(customerDTO, adressDTO);
    }


    private static void customerReturnMovie() {
	MovieReturn movieReturn = new MovieReturn();
	movieReturn.returnMovie(15879L);
    }

}


