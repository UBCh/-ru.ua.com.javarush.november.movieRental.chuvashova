package com.javarush;

import com.javarush.DTO.AdressDTO;
import com.javarush.DTO.CustomerDTO;
import com.javarush.entity.Address;
import com.javarush.entity.City;
import com.javarush.entity.Customer;
import com.javarush.entity.Store;
import com.javarush.repository.*;
import com.javarush.services.AddressService;
import com.javarush.services.CityService;
import com.javarush.services.CustomerService;
import com.javarush.session_provider.PropertiesSessionProvider;

public class BuyerRegistration {


    EntityRepository<Customer> customerRepository = new CustomerRepository(new PropertiesSessionProvider());


    EntityRepository<Address> addressRepository = new AddressRepository(new PropertiesSessionProvider());


    EntityRepository<Store> storeRepository = new StoreRepository(new PropertiesSessionProvider());


    EntityRepository<City> cityRepository = new CityRepository(new PropertiesSessionProvider());


    AddressService addressService = new AddressService(addressRepository);


    CustomerService customerService = new CustomerService(customerRepository, storeRepository);


    CityService cityService = new CityService(cityRepository);


    public void registerCustomer(CustomerDTO customerDTO, AdressDTO adressDTO) {


	City city = cityService.getCity(customerDTO.getCityName());
	adressDTO.setCity(city);
	Address address = addressService.createNewAddress(adressDTO);
	customerDTO.setAddress(address);
	Store store = customerService.getStore(customerDTO.getStoreNumber());
	customerDTO.setStore(store);
	Customer newCustomer = customerService.createNewCustomer(customerDTO);
	System.out.print(newCustomer.getLastName() + newCustomer.getLast_update());
    }

}
