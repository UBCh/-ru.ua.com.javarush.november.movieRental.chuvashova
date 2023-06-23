package com.javarush.DTO;

import com.javarush.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdressDTO {

    private String adress;


    private String address2;


    private String district;


    private City city;


    private String postalCod;


    private String phone;


    public AdressDTO(String adress, String address2, String district, String postalCod, String phone) {
	this.adress = adress;
	this.address2 = address2;
	this.district = district;
	this.postalCod = postalCod;
	this.phone = phone;
    }
}
