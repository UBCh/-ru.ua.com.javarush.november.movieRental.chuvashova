package com.javarush;

import com.javarush.DTO.AdressDTO;
import com.javarush.DTO.CustomerDTO;
import com.javarush.DTO.FilmDTO;
import com.javarush.entity.Customer;
import com.javarush.entity.Film;
import com.javarush.entity.Rental;
import com.javarush.services.CustomerService;
import com.javarush.services.FilmService;

import java.util.Map;


public class Main {
    public static Long newIdRental = 0L;


    public static void main(String[] args) {

	addCustomer();
	addMovie();
	customerRentalMovie();
	customerReturnMovie();
    }


    private static void addMovie() {

	FilmDTO filmDTO = new creatorDTO().createFilmDTO();
	MovieRegistration movieRentalRegistration = new MovieRegistration(filmDTO);
	movieRentalRegistration.registerMovie();

    }


    private static void addCustomer() {


	CustomerDTO customerDTO = new creatorDTO().createCustomerDTO();
	AdressDTO adressDTO = new creatorDTO().createAddressDTO();
	BuyerRegistration buyerRegistration = new BuyerRegistration();
	buyerRegistration.registerCustomer(customerDTO, adressDTO);
    }


    private static void customerReturnMovie() {
	MovieReturn movieReturn = new MovieReturn();
	movieReturn.returnMovie(newIdRental);
    }


    private static void customerRentalMovie() {
	Map dataBuildingForRent = new creatorDTO().createDataBuildingForRent();
	CustomerService customerService = (CustomerService) dataBuildingForRent.get("customerService");
	FilmService filmService = (FilmService) dataBuildingForRent.get("filmService");
	Integer idCustomer = (Integer) dataBuildingForRent.get("idCustomer");
	Customer customer = customerService.getCustomerById((Integer) dataBuildingForRent.get("idCustomer"));
	Film film = filmService.getFilmByTitle((String) dataBuildingForRent.get("titleFilm"));
	Double denga = ((Integer) dataBuildingForRent.get("idCustomer")).doubleValue();
	dataBuildingForRent.get("Deposit");
	RentMovie rentMovie = payDeposit(denga);
	if (rentMovie.checkMovieAvailability(film.getId())) {
	    Rental rental = rentMovie.filmRental(film, customer, (Integer) dataBuildingForRent.get("storeId"));
	    newIdRental = Long.valueOf(rental.getId());
	    System.out.println("film " + dataBuildingForRent.get("titleFilm") + " арендован " + rental.getId() + "номер аренды" + customer.getFirstName() + "=pokupatel");
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


