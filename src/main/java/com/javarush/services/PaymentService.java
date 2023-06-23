package com.javarush.services;

import com.javarush.DTO.PaymentDTO;
import com.javarush.entity.Payment;
import com.javarush.repository.EntityRepository;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    EntityRepository<Payment> paymentRepository;


    public PaymentService(EntityRepository<Payment> paymentRepository) {
	this.paymentRepository = paymentRepository;
    }


    @SneakyThrows
    public Payment createPayment(PaymentDTO paymentDTO) {
	Map<String, Object> map = new HashMap<>();
	map.put("customer", paymentDTO.getCustomer());
	map.put("amount", paymentDTO.getAmount());
	map.put("staff", paymentDTO.getStaff());
	map.put("rental", paymentDTO.getRental());
	map.put("payment_date", paymentDTO.getRental().getRentalDate());
	paymentRepository.create(map);
	return paymentRepository.findByContent(String.valueOf(paymentDTO.getRental().getId()));

    }


    public Payment getPaymentById(Long idPayment) {
	return paymentRepository.findById(idPayment);

    }

}
