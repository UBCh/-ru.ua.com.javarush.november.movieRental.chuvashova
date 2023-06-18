package com.javarush.repository;


import com.javarush.entity.Film;
import com.javarush.entity.Language;
import com.javarush.entity.Rating;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class FilmRepository implements EntityRepository<Film> {

    SessionProvider sessionProvider;


    public FilmRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    public List<Film> getAll() {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (
		Session session = sessionFactory.openSession()) {
	    Query<Film> query = session.createNativeQuery("SELECT * FROM film", Film.class);
	    return query.list();
	}

    }


    @Override
    public void create(Map<String, Object> map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Film film = new Film();
	film.setTitle((String) map.get("title"));
	film.setReleaseYear((Integer) map.get("releaseYear"));
	film.setLanguage((Language) map.get("language"));
	film.setOriginalLanguage((Language) map.get("original_language"));
	film.setRentalDuration((Short) map.get("rentalDuration"));
	film.setRentalRate((BigDecimal) map.get("rentalRate"));
	film.setLength((Integer) map.get("length"));
	film.setReplacementCost((BigDecimal) map.get("replacementCost"));
	film.setRating((Rating) map.get("rating"));
	film.setSpecialFeatures((String) map.get("specialFeatures"));
	film.setOriginalLanguage1((Long) map.get("original_language1"));
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(film);
	    transaction.commit();
	}

    }


    @Override
    public void delete(Film tableEntity) {

    }


    @Override
    public void save(Film tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(tableEntity);
	    transaction.commit();
	}

    }


    @Override
    public void update(Film tableEntity) {
    }


    @Override
    public Film findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Film> query = sessionFactory.openSession().createQuery("select f from Film f  where f.id = :ID", Film.class);
	query.setParameter("ID", id);
	return query.getSingleResult();
    }


    @Override
    public Film findByContent(String title) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Film> query = sessionFactory.openSession().createQuery("select f from Film f  where  f.title = :title", Film.class);
	query.setParameter("title", title);
	return query.getSingleResult();
    }
}
