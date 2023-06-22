package com.javarush.repository;

import com.javarush.entity.FilmActor;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilmActorRepository implements EntityRepository<FilmActor> {

    public List<FilmActor> aList = new ArrayList<>();


    SessionProvider sessionProvider;


    public FilmActorRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map map) {

    }


    @Override


    public List<FilmActor> getAll() {
	if (aList.size() != 0) {
	    return aList;
	}
	aList.clear();
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Query<FilmActor> filmActorQuery = session.createQuery("select f from FilmActor f", FilmActor.class);
	    List<FilmActor> filmActors = filmActorQuery.list();
	    aList = filmActorQuery.list();
	}
	return aList;

    }


    @Override
    public void delete(FilmActor tableEntity) {

    }


    @Override
    public void save(FilmActor tableEntity) {
	FilmActor filmActor = tableEntity;
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(filmActor);
	    transaction.commit();
	}
    }


    @Override
    public void update(FilmActor tableEntity) {

    }


    @Override
    public FilmActor findById(long filmId) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<FilmActor> query = sessionFactory.openSession().createNativeQuery("select * from film_Actor   where film_id = :film_id", FilmActor.class);
	query.setParameter("film_id", filmId);
	aList = query.list();
	return aList.get(0);

    }


    @Override
    public FilmActor findByContent(String content) {
	return null;
    }


    @Override
    public List<FilmActor> findList(String filmId) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<FilmActor> query = sessionFactory.openSession().createNativeQuery("select * from film_Actor   where film_id = :film_id", FilmActor.class);
	query.setParameter("film_id", filmId);
	return query.list();
    }
}
