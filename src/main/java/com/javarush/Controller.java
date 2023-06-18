package com.javarush;

import com.javarush.entity.Address;
import com.javarush.entity.City;
import com.javarush.entity.Customer;
import com.javarush.entity.Store;
import com.javarush.repository.*;
import com.javarush.services.AddressService;
import com.javarush.services.CityService;
import com.javarush.services.CreateCustomerService;
import com.javarush.session_provider.PropertiesSessionProvider;

public class Controller {

    public static void main(String[] args) {


	EntityRepository<Customer> customerRepository = new CustomerRepository(new PropertiesSessionProvider());
	EntityRepository<Address> addressRepository = new AddressRepository(new PropertiesSessionProvider());
	EntityRepository<Store> storeRepository = new StoreRepository(new PropertiesSessionProvider());
	EntityRepository<City> cityRepository = new CityRepository(new PropertiesSessionProvider());


	AddressService addressService = new AddressService(addressRepository);
	CreateCustomerService customerService = new CreateCustomerService(customerRepository, storeRepository);
	CityService cityService = new CityService(cityRepository);

	City city = cityService.getCity("Abu Dhabi");
	Address address = addressService.createNewAddress("MySakila Drive", "", "Alberta", city, "156675", "97655434321");
	Store store = customerService.getStore(1);
	Customer newCustomer = customerService.createNewCustomer(store, "manunya", "pisakina", "qwertya@gmail.ru", address);
	String date = String.valueOf(newCustomer.getLast_update());
	String city1 = newCustomer.getAddress().getCity().getCity();
	System.out.println(city1);
	System.out.println(date);
	System.out.println(newCustomer.getLastName());

    }
}


