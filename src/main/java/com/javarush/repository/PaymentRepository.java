package com.javarush.repository;



import com.javarush.entitie.Payment;
import com.javarush.session_provider.SessionProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PaymentRepository implements EntityRepository<Payment>{

    SessionProvider sessionProvider;

    public PaymentRepository(SessionProvider sessionProvider) {
	this.sessionProvider = sessionProvider;
    }

    @Override
    public void delete(Payment tableEntity) {

    }

    @Override
    public void save(Payment tableEntity) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
       Payment payment=  tableEntity;
        try(Session session=sessionFactory.openSession()){
            Transaction transaction=session.beginTransaction();
            session.save(payment);
            transaction.commit();
        }
    }

    @Override
    public void update(Payment tableEntity) {

    }

    @Override
    public Payment findById(long id) {
        SessionFactory sessionFactory = sessionProvider.getSessionFactory();
        try(Session session=sessionFactory.openSession()){
            Payment payment = session.find(Payment.class, id);
            return  payment;}
    }
}
