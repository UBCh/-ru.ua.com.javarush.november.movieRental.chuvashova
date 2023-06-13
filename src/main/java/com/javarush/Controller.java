package com.javarush;

import com.javarush.entitie.Film;
import com.javarush.services.CustomerService;
import com.javarush.services.ManagerService;

import java.util.Optional;

public class Controller {

    public static void main(String[] args){

        ManagerService managerService=new ManagerService();
        Film film = managerService.getFilm(1);
        System.out.println(film.getTitle());

//        CustomerService customerService=new CustomerService();
//         customerService.createNewCustomer("join","malkovich","blabla@gmail.ru", 1);

    }
}
