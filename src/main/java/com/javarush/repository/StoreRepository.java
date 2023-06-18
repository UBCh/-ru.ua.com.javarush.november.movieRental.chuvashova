package com.javarush.repository;


import com.javarush.entity.Store;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Map;

public class StoreRepository implements EntityRepository<Store> {

    SessionProvider sessionProvider;


    public StoreRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public void delete(Store tableEntity) {

    }


    @Override
    public void save(Store tableEntity) {

    }


    @Override
    public void update(Store tableEntity) {

    }


    @Override
    public Store findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Store> query = sessionFactory.openSession().createQuery("select s from Store s  where s.id = :ID", Store.class);
	query.setParameter("ID", id);
	return query.getSingleResult();

    }


    @Override
    public Store findByContent(String content) {
	return null;
    }
}
