package com.javarush.services;

import com.javarush.entity.Address;
import com.javarush.entity.City;
import com.javarush.repository.EntityRepository;

import java.util.HashMap;
import java.util.Map;

public class AddressService {

    EntityRepository<Address> addressRepository;


    public AddressService(EntityRepository<Address> addressRepository) {
	this.addressRepository = addressRepository;
    }


    public Address createNewAddress(String adress, String address2, String district, City city, String postalCod, String phone) {

	Map<String, Object> map = new HashMap<>();
	map.put("address", adress);
	map.put("address2", address2);
	map.put("district", district);
	map.put("city", city);
	map.put("postalCod", postalCod);
	map.put("phone", phone);

	addressRepository.create(map);
	return addressRepository.findByContent(phone);
    }

}
