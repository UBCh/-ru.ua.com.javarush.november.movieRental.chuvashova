package com.javarush;

import com.javarush.entity.Rental;
import com.javarush.repository.EntityRepository;
import com.javarush.repository.RentalRepository;
import com.javarush.services.RentalService;
import com.javarush.session_provider.PropertiesSessionProvider;

public class MovieReturn {

    private final EntityRepository<Rental> rentalRepository = new RentalRepository(new PropertiesSessionProvider());


    private final RentalService rentalService = new RentalService(rentalRepository);


    public void returnMovie(Long idRental) {
	Rental oldRental = rentalService.getRentalById(idRental);
	Rental rental = rentalService.closeRental(idRental);
	System.out.println(oldRental.getId() + " старая дата " + oldRental.getReturnDate());
	System.out.println("событие аренды= " + rental.getId() + " успешно закрыто " + rental.getReturnDate());
    }

}
