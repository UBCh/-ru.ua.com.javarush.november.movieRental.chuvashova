package com.javarush.repository;

import com.javarush.entity.Film;
import com.javarush.entity.Inventory;
import com.javarush.entity.Store;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class InventoryRepository implements EntityRepository<Inventory> {

    SessionProvider sessionProvider;


    public InventoryRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public List<Inventory> findList(String filmId) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Inventory> query = sessionFactory.openSession().createNativeQuery("select * from inventory   where film_id = :film_id", Inventory.class);
	query.setParameter("film_id", filmId);
	List<Inventory> list = query.list();
	return list;
    }


    @Override
    public void create(Map<String, Object> map) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Inventory inventory = new Inventory();
	inventory.setFilm((Film) map.get("film"));
	inventory.setStore((Store) map.get("store"));
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(inventory);
	    transaction.commit();
	}

    }


    @Override
    public Inventory findByContent(String dataInventory) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Inventory> query = sessionFactory.openSession().createQuery("select i from Inventory i  where i.last_update = :dataInventory", Inventory.class);
	query.setParameter("dataInventory", dataInventory);
	return query.getSingleResult();
    }


    @Override
    public List<Inventory> getAll() {
	return null;
    }


    @Override
    public void delete(Inventory tableEntity) {

    }


    @Override
    public void save(Inventory tableEntity) {

    }


    @Override
    public void update(Inventory tableEntity) {

    }


    @Override
    public Inventory findById(long id) {
	return null;
    }

}
