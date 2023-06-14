package com.javarush.repository;



import com.javarush.entitie.ActiveIndicator;
import com.javarush.entitie.Address;
import com.javarush.entitie.Customer;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Map;

public class CustomerRepository implements EntityRepository<Customer>{

    SessionProvider sessionProvider;

    public CustomerRepository(SessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }


    @Override
    public void create(Map<String,Object> map) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        Customer customer=new Customer();
        customer.setFirstName((String) map.get("FirstName"));
        customer.setLastName((String) map.get("LastName"));
        customer.setEmail((String) map.get("Email"));
        customer.setAddress((Address) map.get("Address"));
        customer.setActive(ActiveIndicator.Y);
          try(Session session=sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.persist(customer);
            transaction.commit();
    }}


    @Override
    public void delete(Customer tableEntity) {

    }

    @Override
    public void save(Customer tableEntity) {

    }

    @Override
    public void update(Customer tableEntity) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        Customer customer=tableEntity;
        try(Session session=sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.save(customer);
            transaction.commit();
    } }

    @Override
    public Customer findById(long id) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try(Session session=sessionFactory.openSession()){
            Customer customer = session.find(Customer.class, id);
            return  customer;}
    }
}
