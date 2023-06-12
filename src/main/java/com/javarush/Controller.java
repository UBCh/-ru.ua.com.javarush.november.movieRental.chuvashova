package com.javarush;

import com.javarush.services.CustomerService;
import com.javarush.services.ManagerService;

public class Controller {

    public static void main(String[] args){

        ManagerService managerService=new ManagerService();
        managerService.addMovieToDatabase();

        CustomerService customerService=new CustomerService();
         customerService.createNewCustomer("join","malkovich","blabla@gmail.ru", 1);

    }
}
