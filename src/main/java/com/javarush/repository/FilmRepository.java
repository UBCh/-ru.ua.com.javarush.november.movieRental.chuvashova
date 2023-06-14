package com.javarush.repository;


import com.javarush.entitie.Film;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class FilmRepository implements EntityRepository<Film>{

    SessionProvider sessionProvider;

    public FilmRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    public List<Film> getAll() {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try(
		Session session=sessionFactory.openSession()) {
	    Query<Film> query = session.createNativeQuery("SELECT * FROM film", Film.class);
	    return query.list();
	}

    }


    @Override
    public void create(Map<String, Object> map) {

    }

    @Override
    public void delete(Film tableEntity) {

    }

    @Override
    public void save(Film tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try(Session session=sessionFactory.openSession()){
	    Transaction transaction=session.beginTransaction();
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
}
