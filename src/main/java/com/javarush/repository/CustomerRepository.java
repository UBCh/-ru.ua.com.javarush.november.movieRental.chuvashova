package com.javarush.repository;



import com.javarush.entitie.Customer;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerRepository implements EntityRepository<Customer>{

    SessionProvider sessionProvider;

    public CustomerRepository(SessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }

    @Override
    public void delete(Customer tableEntity) {

    }

    @Override
    public void save(Customer tableEntity) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        Customer customer=tableEntity;
        try(Session session=sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }

    }

    @Override
    public void update(Customer tableEntity) {

    }


    @Override
    public Customer findById(long id) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try(Session session=sessionFactory.openSession()){
           Customer customer = session.find(Customer.class, id);
            return  customer;}
    }
}
