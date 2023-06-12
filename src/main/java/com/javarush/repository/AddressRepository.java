package com.javarush.repository;


import com.javarush.entitie.Address;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddressRepository implements EntityRepository<Address>{

    SessionProvider sessionProvider;

    public AddressRepository(SessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }


    @Override
    public void delete(Address tableEntity) {

    }

    @Override
    public void save(Address tableEntity) {

    }

    @Override
    public void update(Address tableEntity) {

    }

    @Override
    public Address findById(long id) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try(Session session=sessionFactory.openSession()){
            return session.find(Address.class, id) ;}
    }
}
