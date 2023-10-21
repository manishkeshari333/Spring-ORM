package com.manish.keshari.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.manish.keshari.hibernate.model.Movie;
import com.manish.keshari.hibernate.util.HibernateSessionFactory;

public class AddMovie {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

		// create session
		Session session = sessionFactory.openSession();

		Movie mov = new Movie();
		mov.setId(5);
		mov.setDirector("Ajay");
		mov.setMovieName("Work");

		// here we do transaction then
		session.beginTransaction();

		// save object in session
		session.save(mov);

		// then we do get transaction and commit on DB
		session.getTransaction().commit();
		System.out.println("Data is saved");

		// close session
		session.close();

	}

}
