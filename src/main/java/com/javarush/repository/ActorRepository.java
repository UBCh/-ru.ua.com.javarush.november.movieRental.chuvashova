package com.javarush.repository;

import com.javarush.entity.Actor;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;

public class ActorRepository implements EntityRepository<Actor> {

    SessionProvider sessionProvider;


    public ActorRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public List<Actor> getAll() {
	return null;
    }


    @Override
    public void delete(Actor tableEntity) {

    }


    @Override
    public void save(Actor tableEntity) {

    }


    @Override
    public void update(Actor tableEntity) {

    }


    @Override
    public Actor findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    return session.find(Actor.class, id);
	}
    }


    @Override
    public Actor findByContent(String content) {
	return null;
    }


    @Override
    public List<Actor> findList(String sign) {
	return null;
    }

}
