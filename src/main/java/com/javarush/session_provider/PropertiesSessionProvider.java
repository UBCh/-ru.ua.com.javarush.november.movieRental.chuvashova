package com.javarush.session_provider;



import com.javarush.entities.films.*;
import com.javarush.entities.servises.Inventory;
import com.javarush.entities.servises.Payment;
import com.javarush.entities.servises.Rental;
import com.javarush.entities.users.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropertiesSessionProvider implements SessionProvider {
    @Override
    public SessionFactory getSessionFactory() {
	return new Configuration()
		.addAnnotatedClass(Actor.class)
		.addAnnotatedClass(Category.class)
		.addAnnotatedClass(Film.class)
		.addAnnotatedClass(Film_actor.class)
		.addAnnotatedClass(Film_category.class)
		.addAnnotatedClass(Film_text.class)
		.addAnnotatedClass(Language.class)
		.addAnnotatedClass(Address.class)
		.addAnnotatedClass(City.class)
		.addAnnotatedClass(Country.class)
		.addAnnotatedClass(Customer.class)
		.addAnnotatedClass(Staff.class)
		.addAnnotatedClass(Store.class)
		.addAnnotatedClass(Inventory.class)
		.addAnnotatedClass(Payment.class)
		.addAnnotatedClass(Rental.class)
		.buildSessionFactory();
    }
}