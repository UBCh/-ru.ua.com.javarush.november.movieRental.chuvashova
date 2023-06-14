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

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    SessionProvider sessionProvider=new PropertiesSessionProvider();



     public  void createNewCustomer(Store store,String first_name, String last_name, String email, Address address){
	 CustomerRepository customerRepository=new CustomerRepository(sessionProvider) ;
	 Map<String,Object> map=new HashMap<>();
	 map.put("FirstName", first_name);
	 map.put("LastName", last_name);
	 map.put("Email", email);
	 map.put("Address", address);
	 customerRepository.create(map);
     }

     public Address getAddress(int idAddress){
	 AddressRepository addressRepository=new AddressRepository(sessionProvider);
	 return addressRepository.findById(idAddress);
     }

    public Store getStore(int idAddress){
	StoreRepository storeRepository = new StoreRepository(sessionProvider);
	return storeRepository.findById(idAddress);
    }


}
