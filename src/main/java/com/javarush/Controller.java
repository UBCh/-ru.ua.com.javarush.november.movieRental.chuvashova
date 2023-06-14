package com.javarush;

import com.javarush.entitie.Address;
import com.javarush.entitie.Film;
import com.javarush.entitie.Store;
import com.javarush.services.CustomerService;
import com.javarush.services.ManagerService;

import java.util.Optional;

public class Controller {

    public static void main(String[] args){

//        ManagerService managerService=new ManagerService();
//        Film film = managerService.getFilm(1);
//        System.out.println(film.getTitle());

        CustomerService customerService=new CustomerService();
        Address address=customerService.getAddress(500);
        Store store=customerService.getStore(1);
        customerService.createNewCustomer(store,"join","malkovich","blabla@gmail.ru", address);

    }
}
