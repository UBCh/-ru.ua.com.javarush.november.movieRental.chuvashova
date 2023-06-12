package com.javarush.repository;


import com.javarush.entitie.servise.Rental;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class RentalRepository implements  EntityRepository<Rental>{


    SessionProvider sessionProvider;

    public RentalRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }

    @Override
    public void delete(Rental tableEntity) {

    }

    @Override
    public void save(Rental tableEntity) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Rental rental=  tableEntity;
	try(Session session=sessionFactory.openSession()){
	    Transaction transaction=session.beginTransaction();
	    session.save(rental);
	    transaction.commit();
	}
    }

    @Override
    public void update(Rental tableEntity) {

    }

    @Override
    public Rental findById(long id) {
	return null;
    }
}
