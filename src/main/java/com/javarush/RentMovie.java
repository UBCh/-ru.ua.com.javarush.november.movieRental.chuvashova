package com.javarush;

import com.javarush.DTO.PaymentDTO;
import com.javarush.DTO.RentalDTO;
import com.javarush.entity.*;
import com.javarush.repository.*;
import com.javarush.services.*;
import com.javarush.session_provider.PropertiesSessionProvider;

import java.math.BigDecimal;
import java.util.List;

public class RentMovie {

    public Double deposit;


    EntityRepository<Inventory> inventoryRepository = new InventoryRepository(new PropertiesSessionProvider());


    EntityRepository<Rental> rentalRepository = new RentalRepository(new PropertiesSessionProvider());


    EntityRepository<Staff> staffRepository = new StaffRepository(new PropertiesSessionProvider());


    EntityRepository<Store> storeRepository = new StoreRepository(new PropertiesSessionProvider());


    EntityRepository<Payment> paymentRepository = new PaymentRepository(new PropertiesSessionProvider());


    RentalService rentalService = new RentalService(rentalRepository);


    InventoryService inventoryService = new InventoryService(inventoryRepository);


    StaffService staffService = new StaffService(staffRepository);


    StoreService storeService = new StoreService(storeRepository);


    PaymentService paymentService = new PaymentService(paymentRepository);


    public Rental filmRental(Film film, Customer customer, Integer storeId) {
	Store store = storeService.getStoreById(storeId);
	Inventory inventory = inventoryService.createInventory(film, store);
	RentalDTO rentalDTO = new RentalDTO();
	rentalDTO.setCustomer(customer);
	rentalDTO.setInventory(inventory);
	rentalDTO.setStaff(store.getStaff());
	Rental rental = rentalService.createRental(rentalDTO);
	PaymentDTO paymentDTO = new PaymentDTO();
	paymentDTO.setAmount(BigDecimal.valueOf(deposit));
	paymentDTO.setRental(rental);
	paymentDTO.setStaff(store.getStaff());
	paymentDTO.setCustomer(customer);
	paymentService.createPayment(paymentDTO);
	return rental;
    }


    public boolean checkMovieAvailability(Integer idFilm) {
	List<Integer> listIdInventory = inventoryService.getListIdInventory(idFilm);
	if (listIdInventory.size() == 0) {
	    return true;
	} else return !rentalService.checkUnclosedRental(listIdInventory);
    }


    public Double getDeposit() {
	return deposit;
    }


    public RentMovie setDeposit(Double deposit) {
	this.deposit = deposit;
	return this;
    }

}
