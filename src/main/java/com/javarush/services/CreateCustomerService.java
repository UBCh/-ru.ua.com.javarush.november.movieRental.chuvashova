package com.javarush.services;


import com.javarush.entity.Address;
import com.javarush.entity.Customer;
import com.javarush.entity.Store;
import com.javarush.repository.EntityRepository;

import java.util.HashMap;
import java.util.Map;

public class CreateCustomerService {

    EntityRepository<Customer> customerRepository;


    EntityRepository<Store> storeRepository;


    public CreateCustomerService(EntityRepository<Customer> customerRepository,
				 EntityRepository<Store> storeRepository) {
	this.customerRepository = customerRepository;
	this.storeRepository = storeRepository;

    }


    public Customer createNewCustomer(Store store, String first_name, String last_name, String email, Address address) {
	Map<String, Object> map = new HashMap<>();
	map.put("Store", store);
	map.put("FirstName", first_name);
	map.put("LastName", last_name);
	map.put("Email", email);
	map.put("Address", address);
	customerRepository.create(map);
	return customerRepository.findByContent(email);
    }


    public Store getStore(int idAddress) {

	return storeRepository.findById(idAddress);
    }

}
