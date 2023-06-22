package com.javarush.repository;

import com.javarush.entity.FilmText;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

public class FilmTextRepository implements EntityRepository<FilmText> {

    SessionProvider sessionProvider;


    public FilmTextRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	FilmText filmText = new FilmText();
	filmText.setFilmId((Integer) map.get("id"));
	filmText.setTitle((String) map.get("title"));
	filmText.setDescription((String) map.get("description"));
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(filmText);
	    transaction.commit();
	}

    }


    @Override
    public List<FilmText> getAll() {
	return null;
    }


    @Override
    public void delete(FilmText tableEntity) {

    }


    @Override
    public void save(FilmText tableEntity) {

    }


    @Override
    public void update(FilmText tableEntity) {

    }


    @Override
    public FilmText findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    return session.find(FilmText.class, id);
	}

    }


    @Override
    public FilmText findByContent(String content) {
	return null;
    }


    @Override
    public List<FilmText> findList(String id) {
	return null;
    }
}
