package com.javarush.repository;


import com.javarush.entity.Customer;
import com.javarush.entity.Payment;
import com.javarush.entity.Rental;
import com.javarush.entity.Staff;
import com.javarush.session_provider.SessionProvider;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PaymentRepository implements EntityRepository<Payment> {

    SessionProvider sessionProvider;


    public PaymentRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Payment payment = new Payment();
	payment.setPaymentDate((Date) map.get("payment_date"));
	payment.setLast_update(new Date());
	payment.setAmount((BigDecimal) map.get("amount"));
	payment.setCustomer((Customer) map.get("customer"));
	payment.setStaff((Staff) map.get("staff"));
	payment.setRental((Rental) map.get("rental"));
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(payment);
	    transaction.commit();
	}
    }


    @Override
    public void save(Payment tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Payment payment = tableEntity;
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(payment);
	    transaction.commit();
	}
    }


    @Override
    public Payment findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Payment payment = session.find(Payment.class, id);
	    return payment;
	}
    }


    @SneakyThrows
    @Override
    public Payment findByContent(String idRental) {

	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Payment> query = sessionFactory.openSession().createNativeQuery("select * from payment   where rental_id = :rental_id", Payment.class);
	query.setParameter("rental_id", idRental);
	return query.getSingleResult();
    }


    @Override
    public List<Payment> getAll() {
	return null;
    }


    @Override
    public void delete(Payment tableEntity) {

    }


    @Override
    public void update(Payment tableEntity) {

    }


    @Override
    public List<Payment> findList(String id) {
	return null;
    }
}
