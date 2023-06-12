package com.javarush.repository;


import com.javarush.entitie.Film;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FilmRepository implements EntityRepository<Film>{

    SessionProvider sessionProvider;

    public FilmRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    public List<Film> getAll() {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try(
		Session session=sessionFactory.openSession()) {
	    Query<Film> query = session.createQuery("from Film", Film.class);
	    return query.list();
	}

    }

    @Override
    public void delete(Film tableEntity) {

    }

    @Override
    public void save(Film tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try(Session session=sessionFactory.openSession()){
	    Transaction transaction=session.beginTransaction();
	    session.persist(tableEntity);
	    transaction.commit();
	   }

    }

    @Override
    public void update(Film tableEntity) {
	    }


    @Override
    public Film findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try(Session session=sessionFactory.openSession()){
	    Film film = session.find(Film.class, id);
	    return  film;}
    }
}
