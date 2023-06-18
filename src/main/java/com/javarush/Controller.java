package com.javarush;

import com.javarush.entity.Address;
import com.javarush.entity.City;
import com.javarush.entity.Customer;
import com.javarush.entity.Store;
import com.javarush.repository.*;
import com.javarush.services.AddressService;
import com.javarush.services.CreateCustomerService;
import com.javarush.session_provider.PropertiesSessionProvider;

public class Controller {

    public static void main(String[] args) {


	EntityRepository<Customer> customerRepository = new CustomerRepository(new PropertiesSessionProvider());
	EntityRepository<Address> addressRepository = new AddressRepository(new PropertiesSessionProvider());
	EntityRepository<Store> storeRepository = new StoreRepository(new PropertiesSessionProvider());
	EntityRepository<City> cityRepository = new CityRepository(new PropertiesSessionProvider());

	City city = cityRepository.findByContent("Abu Dhabi");
	AddressService addressService = new AddressService(addressRepository);
	CreateCustomerService customerService = new CreateCustomerService(customerRepository, storeRepository);
	Address address = addressService.createNewAddress("47 MySakila Drive", "", "Alberta", city, "123445", "987654321");
	Store store = customerService.getStore(1);
	Customer newCustomer = customerService.createNewCustomer(store, "manunya", "kvakina", "blablablablablabla@gmail.ru", address);
	String date = String.valueOf(newCustomer.getLast_update());
	String city1 = newCustomer.getAddress().getCity().getCity();
	System.out.println(city1);
	System.out.println(date);
	System.out.println(newCustomer.getLastName());

    }
}


