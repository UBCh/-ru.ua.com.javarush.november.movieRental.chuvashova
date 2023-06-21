package com.javarush.services;

import com.javarush.DTO.AdressDTO;
import com.javarush.entity.Address;
import com.javarush.repository.EntityRepository;

import java.util.HashMap;
import java.util.Map;

public class AddressService {

    EntityRepository<Address> addressRepository;


    public AddressService(EntityRepository<Address> addressRepository) {
	this.addressRepository = addressRepository;
    }


    public Address createNewAddress(AdressDTO adressDTO) {

	Map<String, Object> map = new HashMap<>();
	map.put("address", adressDTO.getAdress());
	map.put("address2", adressDTO.getAddress2());
	map.put("district", adressDTO.getDistrict());
	map.put("city", adressDTO.getCity());
	map.put("postalCod", adressDTO.getPostalCod());
	map.put("phone", adressDTO.getPhone());

	addressRepository.create(map);
	return addressRepository.findByContent(adressDTO.getPhone());
    }

}
