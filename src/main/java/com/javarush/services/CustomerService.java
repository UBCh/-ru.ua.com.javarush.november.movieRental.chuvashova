package com.javarush.services;


import com.javarush.DTO.CustomerDTO;
import com.javarush.entity.Customer;
import com.javarush.entity.Store;
import com.javarush.repository.EntityRepository;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    EntityRepository<Customer> customerRepository;


    EntityRepository<Store> storeRepository;


    public CustomerService(EntityRepository<Customer> customerRepository,
			   EntityRepository<Store> storeRepository) {
	this.customerRepository = customerRepository;
	this.storeRepository = storeRepository;

    }


    @SneakyThrows

    public Customer createNewCustomer(CustomerDTO customerDTO) {
	Map<String, Object> map = new HashMap<>();
	map.put("Store", customerDTO.getStore());
	map.put("FirstName", customerDTO.getFirst_name());
	map.put("LastName", customerDTO.getLast_name());
	map.put("Email", customerDTO.getEmail());
	map.put("Address", customerDTO.getAddress());
	customerRepository.create(map);
	return customerRepository.findByContent(customerDTO.getEmail());
    }


    public Store getStore(int idAddress) {

	return storeRepository.findById(idAddress);
    }


    public Customer getCustomerById(Integer idCustomer) {
	return customerRepository.findById(idCustomer);
    }
}
