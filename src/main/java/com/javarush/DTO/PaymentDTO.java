package com.javarush.DTO;

import com.javarush.entity.Customer;
import com.javarush.entity.Rental;
import com.javarush.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {


    private Customer customer;


    private Staff staff;


    private Rental rental;


    private BigDecimal amount;

}
