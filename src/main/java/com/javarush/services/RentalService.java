package com.javarush.services;

import com.javarush.entity.Rental;
import com.javarush.repository.EntityRepository;

import java.util.Date;

public class RentalService {

    EntityRepository<Rental> rentalRepository;


    public RentalService(EntityRepository<Rental> rentalRepository) {
	this.rentalRepository = rentalRepository;
    }


    public Rental closeRental(Long idRental) {
	Rental rentalById = getRentalById(idRental);
	rentalById.setReturnDate(new Date());
	rentalById.setLastUpdate(new Date());
	rentalRepository.update(rentalById);
	return rentalRepository.findById(idRental);

    }


    public Rental getRentalById(Long idRental) {
	return rentalRepository.findById(idRental);

    }
}
