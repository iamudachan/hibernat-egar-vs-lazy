package com.entiry;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EgarVsLazyDemo {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			int id = 1;
			s.beginTransaction();
			
			org.hibernate.query.Query<Instructor> query = s.createQuery("select i from Instructor i "
																		+" JOIN FETCH i.course "
																		+" where i.id= :theInstuctorId ", Instructor.class);
			query.setParameter("theInstuctorId", id);
			Instructor 	instructor = query.getSingleResult();								
			System.out.println("instru ===" +instructor);
			System.out.println("instru ===" +instructor.getCourse());

			s.getTransaction().commit();
			s.close();
			// if ur doign with course as egar laoding then no error 
			System.out.println("instru ===" +instructor.getCourse());
		} finally {
			s.close();
			sf.close();
		}
	}
}
