package com.javarush.DTO;

import com.javarush.entity.Customer;
import com.javarush.entity.Inventory;
import com.javarush.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {


    private Inventory inventory;


    private Customer customer;


    private Staff staff;

}
