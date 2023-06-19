package com.javarush.repository;


import com.javarush.entity.Address;
import com.javarush.entity.City;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class AddressRepository implements EntityRepository<Address> {

    SessionProvider sessionProvider;


    public AddressRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Address address = new Address();
	address.setAddress((String) map.get("address"));
	address.setAddress2((String) map.get("address2"));
	address.setDistrict((String) map.get("district"));
	address.setCity((City) map.get("city"));
	address.setPostalCode((String) map.get("postalCod"));
	address.setPhone((String) map.get("phone"));
	address.setLast_update(new Date());
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(address);
	    transaction.commit();
	}
    }


    @Override
    public List<Address> getAll() {
	return null;
    }


    public Address findByContent(String phone) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Address> query = sessionFactory.openSession().createQuery("select a from Address a  where a.phone = :phone", Address.class);
	query.setParameter("phone", phone);
	return query.getSingleResult();
    }


    @Override
    public void delete(Address tableEntity) {

    }


    @Override
    public void save(Address tableEntity) {

    }


    @Override
    public void update(Address tableEntity) {

    }


    @Override
    public Address findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    return session.find(Address.class, id);
	}
    }

}
