package com.javarush.repository;

import com.javarush.entity.Category;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class CategoryRepository implements EntityRepository<Category> {

    SessionProvider sessionProvider;


    public CategoryRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void save(Category tableEntity) {
	Category category = tableEntity;
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	try (Session session = sessionFactory.openSession()) {
	    Transaction transaction = session.beginTransaction();
	    session.save(category);
	    transaction.commit();
	}
    }


    @Override
    public Category findByContent(String content) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Category> query = sessionFactory.openSession().createQuery("select c from Category c  where c.name = :name", Category.class);
	query.setParameter("name", content);
	return query.getSingleResult();
    }


    @Override
    public void create(Map<String, Object> map) {

    }


    @Override
    public List<Category> getAll() {
	return null;
    }


    @Override
    public void delete(Category tableEntity) {

    }


    @Override
    public void update(Category tableEntity) {

    }


    @Override
    public Category findById(long id) {
	return null;
    }


    @Override
    public List<Category> findList(String id) {
	return null;
    }
}
