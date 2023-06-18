package com.javarush.services;

import com.javarush.entity.City;
import com.javarush.repository.EntityRepository;

public class CityService {

    EntityRepository<City> cityRepository;


    public CityService(EntityRepository<City> cityRepository) {
	this.cityRepository = cityRepository;
    }


    public City getCity(String city) {

	return cityRepository.findByContent(city);
    }


    public City getCityById(Long id) {
	return cityRepository.findById(id);
    }

}
