package com.javarush.repository;


import com.javarush.entitie.users.Address;
import com.javarush.entitie.users.Store;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StoreRepository implements EntityRepository<Store>{

    SessionProvider sessionProvider;

    public StoreRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
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
	try(Session session=sessionFactory.openSession()){
	    return session.find(Store.class, id) ;}

    }
}
