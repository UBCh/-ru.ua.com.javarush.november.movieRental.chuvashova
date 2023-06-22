package com.javarush.repository;

import com.javarush.entity.Language;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class LanguageRepository implements EntityRepository<Language> {


    SessionProvider sessionProvider;


    public LanguageRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public List<Language> getAll() {
	return null;
    }


    @Override
    public void delete(Language tableEntity) {

    }


    @Override
    public void save(Language tableEntity) {

    }


    @Override
    public void update(Language tableEntity) {

    }


    @Override
    public Language findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    return session.find(Language.class, id);
	}
    }


    @Override
    public Language findByContent(String name) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Language> query = sessionFactory.openSession().createQuery("select l from Language l  where l.name = :name", Language.class);
	query.setParameter("name", name);
	return query.getSingleResult();
    }


    @Override
    public List<Language> findList(String id) {
	return null;
    }
}
