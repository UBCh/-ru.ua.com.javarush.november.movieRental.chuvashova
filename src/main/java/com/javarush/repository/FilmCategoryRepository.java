package com.javarush.repository;

import com.javarush.entity.FilmCategory;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class FilmCategoryRepository implements EntityRepository<FilmCategory> {

    SessionProvider sessionProvider;


    public FilmCategoryRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public FilmCategory findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<FilmCategory> query = sessionFactory.openSession().createQuery("select f from FilmCategory f  where f.film.id = :ID", FilmCategory.class);
	query.setParameter("ID", id);
	return query.getSingleResult();
    }


    @Override
    public void save(FilmCategory tableEntity) {
	FilmCategory filmCategory = tableEntity;
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(filmCategory);
	    transaction.commit();
	}
    }


    @Override
    public void update(FilmCategory tableEntity) {

    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public List<FilmCategory> getAll() {
	return null;
    }


    @Override
    public void delete(FilmCategory tableEntity) {

    }


    @Override
    public FilmCategory findByContent(String content) {

	return null;
    }


    @Override
    public List<FilmCategory> findList(String id) {
	return null;
    }

}
