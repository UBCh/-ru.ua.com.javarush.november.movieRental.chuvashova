package com.javarush.repository;


import com.javarush.entity.ActiveIndicator;
import com.javarush.entity.Address;
import com.javarush.entity.Customer;
import com.javarush.entity.Store;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements EntityRepository<Customer> {

    SessionProvider sessionProvider;


    public CustomerRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Customer customer = new Customer();
	customer.setStore_id((Store) map.get("Store"));
	customer.setFirstName((String) map.get("FirstName"));
	customer.setLastName((String) map.get("LastName"));
	customer.setEmail((String) map.get("Email"));
	customer.setAddress((Address) map.get("Address"));
	customer.setActive(ActiveIndicator.Y);
	customer.setCreate_date(new Date());
	customer.setLast_update(new Date());
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(customer);
	    transaction.commit();
	}
    }


    @Override
    public List<Customer> getAll() {
	return null;
    }


    @Override
    public Customer findByContent(String email) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Customer> query = sessionFactory.openSession().createQuery("select c from Customer c  where c.email = :email", Customer.class);
	query.setParameter("email", email);
	return query.getSingleResult();
    }


    @Override
    public void delete(Customer tableEntity) {

    }


    @Override
    public void save(Customer tableEntity) {

    }


    @Override
    public void update(Customer tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Customer customer = tableEntity;
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(customer);
	    transaction.commit();
	}
    }


    @Override
    public Customer findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Customer customer = session.find(Customer.class, id);
	    return customer;
	}
    }

}
