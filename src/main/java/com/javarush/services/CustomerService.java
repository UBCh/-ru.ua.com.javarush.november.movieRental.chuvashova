package com.javarush.services;


import com.javarush.entitie.ActiveIndicator;
import com.javarush.entitie.Address;
import com.javarush.entitie.Customer;
import com.javarush.entitie.Store;
import com.javarush.repository.AddressRepository;
import com.javarush.repository.CustomerRepository;
import com.javarush.repository.StoreRepository;
import com.javarush.session_provider.PropertiesSessionProvider;
import com.javarush.session_provider.SessionProvider;

public class CustomerService {

    SessionProvider sessionProvider=new PropertiesSessionProvider();



     public  void createNewCustomer(String first_name, String last_name, String email, int idAddress){
	 CustomerRepository customerRepository=new CustomerRepository(sessionProvider) ;
	Customer newCustomer=new Customer(first_name, last_name, email);
	 newCustomer.setActive(ActiveIndicator.Y);
         newCustomer.setAddress(getAddress(idAddress));
	 newCustomer.store_id=getStore(idAddress);
	 customerRepository.save(newCustomer);
     }

     private Address getAddress(int idAddress){
	 AddressRepository addressRepository=new AddressRepository(sessionProvider);
	 return addressRepository.findById(idAddress);
     }

    private Store getStore(int idAddress){
	StoreRepository storeRepository = new StoreRepository(sessionProvider);
	return storeRepository.findById(idAddress);
    }


}
