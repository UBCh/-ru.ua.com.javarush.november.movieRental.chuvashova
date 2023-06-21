package com.javarush.repository;


import com.javarush.entity.Payment;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class PaymentRepository implements EntityRepository<Payment> {

    SessionProvider sessionProvider;


    public PaymentRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public List<Payment> getAll() {
	return null;
    }


    @Override
    public void delete(Payment tableEntity) {

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
    public void update(Payment tableEntity) {

    }


    @Override
    public Payment findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Payment payment = session.find(Payment.class, id);
	    return payment;
	}
    }


    @Override
    public Payment findByContent(String payment_date) {

	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Payment> query = sessionFactory.openSession().createQuery("select p from Payment p  where p.paymentDate = :payment_date", Payment.class);
	query.setParameter("payment_date", payment_date);
	return query.getSingleResult();
    }
}
