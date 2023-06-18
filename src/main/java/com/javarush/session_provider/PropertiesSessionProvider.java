package com.javarush.session_provider;


import com.javarush.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class PropertiesSessionProvider implements SessionProvider {

    public PropertiesSessionProvider() {

	Properties properties = new Properties();
	properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
	properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	properties.put(Environment.URL, "jdbc:mysql://localhost:3306/movie");
	properties.put(Environment.USER, "root");
	properties.put(Environment.PASS, "pass");
	properties.put(Environment.HBM2DDL_AUTO, "update");
	properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
	properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/movie");
    }


    @Override
    public SessionFactory getSessionFactory() {
	return new Configuration()
		.addAnnotatedClass(Actor.class)
		.addAnnotatedClass(Category.class)
		.addAnnotatedClass(Film.class)
		.addAnnotatedClass(FilmActor.class)
		.addAnnotatedClass(FilmCategory.class)
		.addAnnotatedClass(FilmText.class)
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