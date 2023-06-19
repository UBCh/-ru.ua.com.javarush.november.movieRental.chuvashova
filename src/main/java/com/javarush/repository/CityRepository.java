package com.javarush.repository;

import com.javarush.entity.City;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class CityRepository implements EntityRepository<City> {
    SessionProvider sessionProvider;


    public CityRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public List<City> getAll() {
	return null;
    }


    @Override
    public void delete(City tableEntity) {

    }


    @Override
    public void save(City tableEntity) {

    }


    @Override
    public void update(City tableEntity) {

    }


    @Override
    public City findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    return session.find(City.class, id);
	}
    }


    @Override
    public City findByContent(String name) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<City> query = sessionFactory.openSession().createQuery("select c from City c  where c.city = :city", City.class);
	query.setParameter("city", name);
	return query.getSingleResult();
    }

}
