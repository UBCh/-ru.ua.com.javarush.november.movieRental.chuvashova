package com.javarush;

import com.javarush.DTO.AdressDTO;
import com.javarush.DTO.CustomerDTO;
import com.javarush.DTO.FilmDTO;
import com.javarush.entity.*;
import com.javarush.repository.*;
import com.javarush.services.CustomerService;
import com.javarush.services.FilmService;
import com.javarush.services.LanguageService;
import com.javarush.session_provider.PropertiesSessionProvider;

import java.math.BigDecimal;

public class Controller {

    public static void main(String[] args) {
	addMovie();
	addCustomer();
	customerRentalMovie();
	customerReturnMovie();
    }


    private static void addMovie() {
	LanguageService languageService = new LanguageService(new LanguageRepository(new PropertiesSessionProvider()));
	Language language = languageService.getLanguage("English");
	Integer[] idActor = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 16, 10};
	BigDecimal i = BigDecimal.valueOf(0);
	FilmDTO filmDTO = new FilmDTO("APOCALYPSE FLAMINGOS 13",
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
		"Muucya", "Popovich",
		"jsssfggd@kbmail.ru", "Arecibo", 1);

	AdressDTO adressDTO = new AdressDTO(
		"MySakila Drive", "",
		"Alberta", "156675",
		"975665434321");
	BuyerRegistration buyerRegistration = new BuyerRegistration();
	buyerRegistration.registerCustomer(customerDTO, adressDTO);
    }


    private static void customerReturnMovie() {
	MovieReturn movieReturn = new MovieReturn();
	movieReturn.returnMovie(16058L);
    }


    private static void customerRentalMovie() {
	EntityRepository<Customer> customerEntityRepository = new CustomerRepository(new PropertiesSessionProvider());
	EntityRepository<Store> storeEntityRepository = new StoreRepository(new PropertiesSessionProvider());
	CustomerService customerService = new CustomerService(customerEntityRepository, storeEntityRepository);
	EntityRepository<Film> filmEntityRepository = new FilmRepository(new PropertiesSessionProvider());
	FilmService filmService = new FilmService(filmEntityRepository);
	Customer customer = customerService.getCustomerById(629);
	Film film = filmService.getFilmByTitle("APOCALYPSE FLAMINGOS 12");
	RentMovie rentMovie = payDeposit(0.444);
	if (rentMovie.checkMovieAvailability(film.getId())) {
	    Rental rental = rentMovie.filmRental(film, customer, 2);
	    System.out.println("film APOCALYPSE FLAMINGOS 12 arendovan" + rental.getId() + "номер аренды" + customer.getFirstName() + "=pokupatel");
	} else {
	    System.out.println("film zanyat ");
	}
    }


    private static RentMovie payDeposit(Double deposite) {
	RentMovie rentMovie = new RentMovie();
	rentMovie.setDeposit(deposite);
	return rentMovie;
    }

}


