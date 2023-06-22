package com.javarush.repository;

import com.javarush.entity.Staff;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;

public class StaffRepository implements EntityRepository<Staff> {

    SessionProvider sessionProvider;


    public StaffRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String, Object> map) {


    }


    @Override
    public List<Staff> getAll() {
	return null;
    }


    @Override
    public void delete(Staff tableEntity) {

    }


    @Override
    public void save(Staff tableEntity) {

    }


    @Override
    public void update(Staff tableEntity) {

    }


    @Override
    public Staff findById(long id) {
	SessionFactory sessionFactory = sessionProvider.getSessionFactory();
	Query<Staff> query = sessionFactory.openSession().createQuery("select s from Staff s  where s.id = :ID", Staff.class);
	query.setParameter("ID", id);
	return query.getSingleResult();
    }


    @Override
    public Staff findByContent(String content) {
	return null;
    }


    @Override
    public List<Staff> findList(String id) {
	return null;
    }
}
