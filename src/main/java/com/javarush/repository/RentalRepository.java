package com.javarush.repository;


import com.javarush.entity.Customer;
import com.javarush.entity.Inventory;
import com.javarush.entity.Rental;
import com.javarush.entity.Staff;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RentalRepository implements EntityRepository<Rental> {


    SessionProvider sessionProvider;


    public RentalRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Rental rental = new Rental();
	rental.setRentalDate(new Date());
	rental.setLast_update(new Date());
	rental.setInventory((Inventory) map.get("inventory"));
	rental.setCustomer((Customer) map.get("customer"));
	rental.setStaff((Staff) map.get("staff"));
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(rental);
	    transaction.commit();
	}
    }


    @Override
    public void save(Rental tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Rental rental = tableEntity;
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(rental);
	    transaction.commit();
	}
    }


    @Override
    public void update(Rental tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Rental rental = tableEntity;
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.update(rental);
	    transaction.commit();
	}
    }


    @Override
    public List<Rental> findList(String inventoryId) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Rental> query = sessionFactory.openSession().createNativeQuery("select * from rental   where inventory_id = :inventory_id", Rental.class);
	query.setParameter("inventory_id", inventoryId);
	return query.list();
    }


    @Override
    public Rental findById(long id) {

	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    return session.find(Rental.class, id);
	}
    }


    @Override
    public List<Rental> getAll() {
	return null;
    }


    @Override
    public void delete(Rental tableEntity) {

    }


    @Override
    public Rental findByContent(String idInventory) {

	return null;
    }

}

