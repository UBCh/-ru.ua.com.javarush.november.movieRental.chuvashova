package com.javarush.services;

import com.javarush.DTO.RentalDTO;
import com.javarush.entity.Rental;
import com.javarush.repository.EntityRepository;
import lombok.SneakyThrows;

import java.util.*;

public class RentalService {

    EntityRepository<Rental> rentalRepository;


    public RentalService(EntityRepository<Rental> rentalRepository) {
	this.rentalRepository = rentalRepository;
    }


    public Rental createRental(RentalDTO rentalDTO) {
	Map<String, Object> map = new HashMap<>();
	map.put("customer", rentalDTO.getCustomer());
	map.put("inventory", rentalDTO.getInventory());
	map.put("staff", rentalDTO.getStaff());
	rentalRepository.create(map);
	ArrayList<Rental> list = (ArrayList<Rental>) rentalRepository.findList(String.valueOf(rentalDTO.getInventory().getId()));
	return sorteDataCreate(list);

    }


    public Rental closeRental(Long idRental) {
	Rental rentalById = getRentalById(idRental);
	rentalById.setReturnDate(new Date());
	rentalById.setLast_update(new Date());
	rentalRepository.update(rentalById);
	return rentalRepository.findById(idRental);

    }


    public Rental getRentalById(Long idRental) {
	return rentalRepository.findById(idRental);

    }


    @SneakyThrows
    public Date getReturnDate(String idRental) {
	return rentalRepository.findByContent(idRental).getReturnDate();
    }


    public boolean checkUnclosedRental(List<Integer> idInventory) {
	for (Integer i : idInventory) {
	    List<Rental> rentalByIdInventory = getRentalByIdInventory(i);
	    for (Rental r : rentalByIdInventory) {
		if (r.getReturnDate() == null) {
		    return true;
		}
	    }
	}
	return false;

    }


    public List getRentalByIdInventory(Integer idInventory) {
	return rentalRepository.findList(String.valueOf(idInventory));

    }


    private Rental sorteDataCreate(List<Rental> list) {
	Collections.sort(list, Comparator.comparing(Rental::getLast_update));
	Rental rental = list.get(list.size() - 1);
	return rental;
    }
}
