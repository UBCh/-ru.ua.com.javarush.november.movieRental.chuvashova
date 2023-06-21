package com.javarush.DTO;

import com.javarush.entity.Address;
import com.javarush.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {


    private Store store;


    private String first_name;


    private String last_name;


    private String email;


    private Address address;


    private String cityName;


    private Integer storeNumber;


    public CustomerDTO(String first_name, String last_name, String email, String cityName, Integer storeNumber) {
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.cityName = cityName;
	this.storeNumber = storeNumber;
    }

}
